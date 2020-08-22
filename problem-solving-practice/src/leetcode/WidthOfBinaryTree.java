package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WidthOfBinaryTree {
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		List<Integer> tree = new ArrayList<>();
		return traverse(root, 0, 1, tree);
	}

	private int traverse(TreeNode root, int level, int nodes, List<Integer> tree) {
		if (root == null) {
			return 0;
		}
		if (level == tree.size()) {
			tree.add(nodes);
		}
		return Math.max(traverse(root.left, level + 1, nodes * 2, tree),
				Math.max(traverse(root.right, level + 1, nodes * 2 + 1, tree), nodes + 1 - tree.get(level)));
	}
}
