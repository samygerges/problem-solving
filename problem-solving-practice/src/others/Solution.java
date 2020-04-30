package others;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public static int longestUnivaluePath(TreeNode root) {
		return longestUnivaluePath(root, 0);
	}

	private static int longestUnivaluePath(TreeNode root, int depth) {
		if (root == null)
			return depth;

		int max = 0;
		if (root.right != null)
			max = Math.max(longestUnivaluePath(root.right, depth) + 1, max);
		if (root.left != null)
			max = Math.max(max, longestUnivaluePath(root.left, depth) + 1);
		return max;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode left1 = new TreeNode(4);
		TreeNode right1 = new TreeNode(5);
		TreeNode right2 = new TreeNode(5);
		TreeNode left2 = new TreeNode(1);
		TreeNode right3 = new TreeNode(1);
		root.right = right1;
		right1.right = right2;
		root.left = left1;
		left1.left = left2;
		left1.right = right3;
		System.out.println(longestUnivaluePath(root));
		System.out.println(1 << 10);
	}
}