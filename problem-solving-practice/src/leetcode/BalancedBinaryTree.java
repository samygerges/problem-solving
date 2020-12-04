package leetcode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		int height = Math.abs(traverse(root.right) - traverse(root.left));

		if (height > 1)
			return false;

		return isBalanced(root.left) && isBalanced(root.right);
	}

	private int traverse(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(traverse(root.left), traverse(root.right)) + 1;
	}
}
