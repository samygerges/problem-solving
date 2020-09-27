package leetcode;

import java.util.Arrays;

public class MaxSumRangeQuery {
	public int maxSumRangeQuery(int[] nums, int[][] requests) {
		int[] count = new int[nums.length];
		for (int i = 0; i < requests.length; i++) {
			count[requests[i][0]]++;
			if (requests[i][1] + 1 < nums.length) {
				count[requests[i][1] + 1]--;
			}
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		Arrays.sort(count);
		Arrays.sort(nums);

		int mod = (int) 1e9 + 7;
		int answer = 0;
		for (int i = 0; i < nums.length; i++) {
			answer = (int) ((answer + ((long) nums[i] * count[i])) % mod);
		}
		return answer;
	}
}
