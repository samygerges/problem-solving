package hackerrank;

public class MaxArraySum {
	static int maxSubsetSum(int[] arr) {
		if (arr.length == 1) {
			return arr[0];
		}
		if (arr.length == 2) {
			return Math.max(arr[0], arr[1]);
		}

		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		int max = dp[1];
		for (int i = 2; i < arr.length; i++) {
			dp[i] = Math.max(Math.max(max, arr[i]), dp[i - 2] + arr[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
