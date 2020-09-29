package binarysearch;

public class SmallestPairSum {
	public int solve(int[] nums) {
		int min = Integer.MAX_VALUE;
		int pref = nums[0];
		for (int i = 2; i < nums.length; i++) {
			pref = Math.min(pref, nums[i - 2]);
			min = Math.min(min, nums[i] + pref);
		}
		return min;
	}
}
