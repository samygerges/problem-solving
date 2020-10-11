package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2
{
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		helper(root, 0, res);
		Collections.reverse(res);
		return res;
	}

	private void helper(TreeNode root, int level, List<List<Integer>> res) {
		if(root == null) {
			return;
		}
		if(res.size() <= level) {
			res.add(new ArrayList<>());
		}
		res.get(level).add(root.val);
		helper(root.left, level + 1, res);
		helper(root.right, level + 1, res);
	}
}
