package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlipMatchVoyage
{
	private int index = 0;

	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage)
	{
		List<Integer> res = new ArrayList<>();
		if (dfs(root, voyage, res))
		{
			return res;
		}
		return Collections.singletonList(-1);
	}

	private boolean dfs(TreeNode root, int[] voyage, List<Integer> res)
	{
		if (root == null)
		{
			return true;
		}
		if (root.val != voyage[index])
		{
			return false;
		}
		index++;
		if (root.left != null && root.left.val != voyage[index])
		{
			res.add(root.val);
			return dfs(root.right, voyage, res) && dfs(root.left, voyage, res);
		}
		return dfs(root.left, voyage, res) && dfs(root.right, voyage, res);
	}
}
