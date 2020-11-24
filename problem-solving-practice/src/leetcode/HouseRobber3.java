package leetcode;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class HouseRobber3 {
	public int rob(TreeNode root) {
        Map<Pair<TreeNode, Boolean>, Integer> memo = new HashMap<>();
		return rob(root, true, memo);
	}

	private int rob(TreeNode root, boolean canTake, Map<Pair<TreeNode, Boolean>, Integer> memo) {
		if (root == null) {
			return 0;
		}

		if (memo.containsKey(new Pair<>(root, canTake))) {
			return memo.get(new Pair<>(root, canTake));
		}

		int sum = canTake ? root.val : 0;
		sum += rob(root.left, !canTake, memo) + rob(root.right, !canTake, memo);
		int sum2 = rob(root.left, canTake, memo) + rob(root.right, canTake, memo);
		int val = Math.max(sum, sum2);
		memo.put(new Pair<>(root, canTake), val);
		return val;
	}
}
