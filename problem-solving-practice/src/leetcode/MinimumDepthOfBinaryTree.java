package leetcode;

public class MinimumDepthOfBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		return minDepth(root, 1);
	}

	private int minDepth(TreeNode root, int level) {
		if (root.left == null && root.right == null)
			return level;

		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;

		if (root.left != null)
			left = minDepth(root.left, level + 1);
		if (root.right != null)
			right = minDepth(root.right, level + 1);

		return Math.min(left, right);
	}
}
