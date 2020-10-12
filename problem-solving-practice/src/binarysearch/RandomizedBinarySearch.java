package binarysearch;

public class RandomizedBinarySearch {
	public int solve(int[] nums) {
		int count = 0;
		boolean[] check = new boolean[nums.length];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				check[i] = true;
			}
			max = Math.max(max, nums[i]);
		}

		for (int i = nums.length - 1; i > -1; i--) {
			if (nums[i] < min && check[i]) {
				count++;
			}
			min = Math.min(min, nums[i]);
		}

		return count;
	}
}
