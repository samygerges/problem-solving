package leetcode;

public class ContiguousSequence {

	public static int findLargestSum(int[] arr) {

		int[][] dp = new int[arr.length][arr.length];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (i == j)
					dp[i][j] = arr[i];
				else {
					dp[i][j] = Math.max(arr[j], arr[j] + dp[i][j - 1]);
				}

				max = Math.max(max, dp[i][j]);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(findLargestSum(new int[] { -8, 3, -2, 4, -10 }));
	}

}
