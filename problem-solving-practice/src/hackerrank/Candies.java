package hackerrank;

import java.util.Arrays;

public class Candies {

	public static void main(String[] args) {
		System.out.println(candies(10, new int[] { 2, 4, 2, 6, 1, 7, 8, 9, 2, 1 }));
	}

	static long candies(int n, int[] arr) {
		if (n == 1)
			return 1;
		long[] dp = new long[arr.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				dp[i] += dp[i - 1];
			}
		}
		long sum = dp[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > arr[i + 1] && dp[i] <= dp[i + 1]) {
				dp[i] = dp[i + 1] + 1;
			}
			sum += dp[i];
		}
		return sum;
	}

}
