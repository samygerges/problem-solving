package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers
{
	public int sumNumbers(TreeNode root) {
		if(root == null)
		{
			return 0;
		}
		List<Integer> nums = new ArrayList<>();
		getAllLeafs(root, nums, "");

		int sum = nums.stream().reduce(0, Integer::sum);
		return sum;
	}

	private void getAllLeafs(TreeNode root, List<Integer> nums, String num)
	{
		if(root.right == null && root.left == null)
		{
			nums.add(Integer.parseInt(num + root.val));
			return;
		}
		if(root.left != null)
		{
			getAllLeafs(root.left, nums, num + root.val);
		}
		if(root.right != null)
		{
			getAllLeafs(root.right, nums, num + root.val);
		}
	}
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
