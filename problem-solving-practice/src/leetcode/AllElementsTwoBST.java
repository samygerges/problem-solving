package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsTwoBST {
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> list = new ArrayList<>();
		traverse(root1, list);
		traverse(root2, list);
		Collections.sort(list);
		return list;
	}

	private void traverse(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		traverse(root.left, list);
		traverse(root.right, list);
	}
}
