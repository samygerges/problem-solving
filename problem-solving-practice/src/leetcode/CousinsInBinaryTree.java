package leetcode;

import javafx.util.Pair;

public class CousinsInBinaryTree {
	public boolean isCousins(TreeNode root, int x, int y) {
		Pair<Integer, Integer> p1 = dfs(root, -1, x, 0);
		Pair<Integer, Integer> p2 = dfs(root, -1, y, 0);
		if (p1 != null && p2 != null && p1.getKey() != p2.getKey() && p1.getValue() == p2.getValue()) {
			return true;
		}
		return false;
	}

	private Pair<Integer, Integer> dfs(TreeNode root, int parent, int x, int depth) {
		if (root == null) {
			return null;
		}

		if (root.val == x) {
			return new Pair<>(parent, depth);
		}

		if (root.left != null) {
			Pair<Integer, Integer> pair = dfs(root.left, root.val, x, depth + 1);
			if (pair != null) {
				return pair;
			}
		}

		return dfs(root.right, root.val, x, depth + 1);
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