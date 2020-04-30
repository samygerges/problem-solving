package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeHasValidSequence
{
	public boolean isValidSequence(TreeNode root, int[] arr)
	{
		String s = "";
		for (int i : arr)
		{
			s += "" + i;
		}

		List<String> allSequences = new ArrayList<>();
		getAllLeafs(root, "", allSequences);
		for (String str : allSequences)
		{
			if (str.equals(s))
			{
				return true;
			}
		}
		return false;
	}

	private void getAllLeafs(TreeNode root, String str, List<String> allSequences)
	{
		if (root.left == null && root.right == null)
		{
			allSequences.add(str + root.val);
		}
		if (root.left != null)
		{
			getAllLeafs(root.left, str + root.val, allSequences);
		}
		if (root.right != null)
		{
			getAllLeafs(root.right, str + root.val, allSequences);
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