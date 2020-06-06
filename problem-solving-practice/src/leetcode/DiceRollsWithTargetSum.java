package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiceRollsWithTargetSum {

	public static void main(String[] args) {
		System.out.println(new DiceRollsWithTargetSum().numRollsToTarget(1, 6, 3));
	}

	private double mod = 1e9 + 7;

	public int numRollsToTarget(int d, int f, int target) {
		List<Integer> dp = new ArrayList<>(Collections.nCopies(target + 1, 0));
		dp.set(0, 1);
		for (int i = 1; i <= d; i++) {
			List<Integer> list = new ArrayList<>(Collections.nCopies(target + 1, 0));
			for (int j = 0; j <= target; j++) {
				for (int k = 1; k <= f; k++) {
					if (j + k <= target) {
						list.set(j + k, (dp.get(j) + list.get(j + k)) % (int) mod);
					}
				}
			}
			dp = list;
		}
		return dp.get(target);
	}
}
