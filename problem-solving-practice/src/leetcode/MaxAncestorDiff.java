package leetcode;

public class MaxAncestorDiff {
	public int maxAncestorDiff(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return maxAncestorDiff(root, root.val, root.val, 0);
	}

	public int maxAncestorDiff(TreeNode root, int min, int max, int ans) {
		if (root == null) {
			return ans;
		}
		ans = Math.max(ans, Math.abs(max - root.val));
		ans = Math.max(ans, Math.abs(root.val - min));

		max = Math.max(max, root.val);
		min = Math.min(min, root.val);

		ans = Math.max(ans, maxAncestorDiff(root.left, min, max, ans));
		ans = Math.max(ans, maxAncestorDiff(root.right, min, max, ans));

		return ans;
	}
}
