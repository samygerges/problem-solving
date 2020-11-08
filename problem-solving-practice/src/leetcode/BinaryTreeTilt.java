package leetcode;

public class BinaryTreeTilt {
	private int tilt = 0;

	public int findTilt(TreeNode root) {
		getTilt(root);
		return tilt;
	}

	private int getTilt(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getTilt(root.left);
		int right = getTilt(root.right);
		tilt += Math.abs(left - right);

		return left + right + root.val;
	}
}
