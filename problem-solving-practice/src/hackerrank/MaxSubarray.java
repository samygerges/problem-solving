package hackerrank;

public class MaxSubarray
{
	static int[] maxSubarray(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		int maxSubarray = arr[0];
		int maxSequence = arr[0];

		for(int i = 1; i < arr.length; i++) {
			dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
			maxSubarray = Math.max(maxSubarray, dp[i]);
			maxSequence = Math.max(maxSequence, Math.max(arr[i], maxSequence + arr[i]));
		}

		return new int[] {maxSubarray, maxSequence};
	}
}
