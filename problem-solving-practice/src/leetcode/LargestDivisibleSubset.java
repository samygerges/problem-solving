package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	public static void main(String[] args) {
		LargestDivisibleSubset s = new LargestDivisibleSubset();
		System.out.println(s.largestDivisibleSubset(new int[] { 1, 2, 4, 8 }));
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		int n = nums.length;
		int[] dp = new int[n];
		int[] index = new int[n];

		Arrays.fill(dp, 1);
		Arrays.fill(index, -1);
		int max = 0;
		int indexMax = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					index[i] = j;
				}
			}
			if (max < dp[i]) {
				max = dp[i];
				indexMax = i;
			}
		}

		int i = indexMax;
		while (i > -1) {
			res.add(nums[i]);
			i = index[i];
		}

		return res;
	}
}
