package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2
{
	public List<List<Integer>> pathSum(TreeNode root, int targetSum)
	{
		List<List<Integer>> res = new ArrayList<>();
		dfs(root, targetSum, 0, res, new ArrayList<>());
		return res;
	}

	private void dfs(TreeNode root, int targetSum, int currentSum, List<List<Integer>> res, List<Integer> list)
	{
		if (root == null)
		{
			return;
		}
		List<Integer> copy = new ArrayList<>(list);
		copy.add(root.val);
		if (currentSum + root.val == targetSum && root.left == null && root.right == null)
		{
			if (!copy.isEmpty())
			{
				res.add(new ArrayList<>(copy));
			}
			return;
		}
		dfs(root.left, targetSum, currentSum + root.val, res, copy);
		dfs(root.right, targetSum, currentSum + root.val, res, copy);
	}
}
