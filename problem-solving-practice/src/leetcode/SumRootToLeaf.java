package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf
{
	public int sumRootToLeaf(TreeNode root) {
		List<Integer> all = new ArrayList<>();
		traverse(root, "", all);
		int sum = 0;
		for(int i : all) {
			sum += i;
		}
		return sum;
	}

	private void traverse(TreeNode root, String current, List<Integer> all) {
		if(root == null) {
			return;
		}

		if(root.left == null && root.right == null) {
			all.add(Integer.parseInt(current + root.val, 2));
			return;
		}
		traverse(root.left, current + root.val, all);
		traverse(root.right, current + root.val, all);
	}
}
