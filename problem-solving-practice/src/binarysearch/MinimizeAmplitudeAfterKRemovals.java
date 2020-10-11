package binarysearch;

import java.util.Arrays;

public class MinimizeAmplitudeAfterKRemovals {

	public static void main(String[] args) {
		System.out.println(new MinimizeAmplitudeAfterKRemovals().solve(new int[] { 1, 0, 1 }, 1));
	}

	public int solve(int[] nums, int k) {
		Arrays.sort(nums);
		int min = nums[nums.length - 1] - nums[0];

		for (int i = 0; i <= k; i++) {
			min = Math.min(min, nums[nums.length - 1 - k + i] - nums[i]);
		}

		return min;
	}
}
