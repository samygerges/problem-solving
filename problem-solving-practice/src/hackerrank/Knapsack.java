package hackerrank;

public class Knapsack {

	public static void main(String[] args) {
		System.out.println(unboundedKnapsack(12, new int[] { 1, 6, 9 }));
	}

	static int unboundedKnapsack(int k, int[] arr) {
		boolean[] dp = new boolean[k + 1];
		for (int j = 0; j < arr.length; j++) {
			for (int r = arr[j]; r <= k; r += arr[j]) {
				dp[r] = true;
			}
			for (int r = 0; r <= k; r++) {
				if (dp[r] && r + arr[j] <= k) {
					dp[r + arr[j]] = true;
				}
			}
		}

		for (int i = k; i > -1; i--) {
			if (dp[i])
				return i;
		}
		return 0;
	}
}
