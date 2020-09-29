package binarysearch;

public class MaximizeMinimumValueAfterKIncrement {
	public static void main(String[] args) {
		System.out.println(new MaximizeMinimumValueAfterKIncrement().solve(new int[] { 0 }, 1, 1));
	}

	public int solve(int[] nums, int size, int k) {
		int min = nums[0];
		for (int i : nums) {
			min = Math.min(min, i);
		}

		long low = min;
		long high = min + k;
		long mid = low + (high - low) / 2;
		long answer = mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (canAchieve(mid, nums, k, size)) {
				answer = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return (int) answer;
	}

	private boolean canAchieve(long mid, int[] nums, int k, int size) {
		long[] a = new long[nums.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = nums[i];
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] < mid) {
				long c = mid - a[i];
				if (k < c)
					return false;
				for (int j = i; j < Math.min((long) i + size, nums.length); j++)
					a[j] += c;
				k -= c;
			}
		}
		return true;
	}
}
