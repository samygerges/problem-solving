package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<List<Integer>> allValues = new ArrayList<>();
		allValues.add(Collections.singletonList(root.val));
		getValues(root, allValues, 1);
		for (int i = 1; i < allValues.size(); i += 2) {
			Collections.reverse(allValues.get(i));
		}
		return allValues;
	}

	private void getValues(TreeNode root, List<List<Integer>> allValues, int level) {
		if (root == null) {
			return;
		}
		List<Integer> nodeValues = new ArrayList<>();
		if (root.left != null) {
			nodeValues.add(root.left.val);
		}
		if (root.right != null) {
			nodeValues.add(root.right.val);
		}
		if (!nodeValues.isEmpty()) {
			if (allValues.size() <= level)
				allValues.add(nodeValues);
			else {
				allValues.get(level).addAll(nodeValues);
			}
		}
		getValues(root.left, allValues, level + 1);
		getValues(root.right, allValues, level + 1);
	}
}
