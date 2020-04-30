package leetcode;

public class MaxSumSubarray {

	/**
	 * array of number like {-1, 2, 3, 1, -3} return the max sum sub array {2, 3, 1}
	 */

	public static int[] maxSumSubarray(int[] arr) {
		if (arr == null || arr.length == 0)
			return null;

		int st = 0;
		int en = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum > maxSum) {
					maxSum = sum;
					st = i;
					en = j;
				}
			}
		}

		int[] res = new int[en - st + 1];
		for (int i = st; i <= en; i++) {
			res[i - st] = arr[i];
		}

		return res;
	}

	public static void main(String[] args) {
		//int[] arr = maxSumSubarray(new int[] { -1, 2, 3, 1, -3 });
		int[] arr = maxSumSubarray(new int[] { -2, 1, -3, 4, -1, 2, 1, 5, -4 });
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
