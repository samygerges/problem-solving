package leetcode;

public class MaxSubarraySumCircular {

	public static void main(String[] args) {
		System.out.println(new MaxSubarraySumCircular().maxSubarraySumCircular(new int[] { 5, 2, -3, 4 }));
		System.out.println(new MaxSubarraySumCircular().maxSubarraySumCircular(new int[] { -2, -3, -1 }));
		System.out.println(new MaxSubarraySumCircular().maxSubarraySumCircular(new int[] { 3, -1, 2, -1 }));
		System.out.println(new MaxSubarraySumCircular().maxSubarraySumCircular(new int[] { 2, -2, 2, 7, 8, 0 }));
	}

	public int maxSubarraySumCircular(int[] A) {
		int max = A[0];

		boolean neg = true;
		boolean pos = true;
		for (int i : A) {
			if (i > 0) {
				neg = false;
			}
			if (i < 0) {
				pos = false;
			}
		}

		int[] dp = new int[A.length];
		dp[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			dp[i] = Math.max(A[i], dp[i - 1] + A[i]);
			max = Math.max(max, dp[i]);
		}
		if (neg || pos) {
			return max;
		}

		int invert = 0;
		for (int i = 0; i < A.length; i++) {
			invert += A[i];
			A[i] *= -1;
		}
		dp[0] = A[0];
		int maxInvert = A[0];
		for (int i = 1; i < A.length; i++) {
			dp[i] = Math.max(A[i], dp[i - 1] + A[i]);
			maxInvert = Math.max(maxInvert, dp[i]);
		}

		invert += maxInvert;

		return Math.max(invert, max);
	}
}