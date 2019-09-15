
public class Knapsack {

	public static int getMaxValue(int[] value, int[] weight, int size) {
		int[][] dp = new int[weight.length + 1][size + 1];

		for (int j = 1; j <= value.length; j++) {
			for (int i = 1; i <= size; i++) {
				if (weight[j - 1] <= i) {
					dp[j][i] = Math.max(value[j - 1] + dp[j - 1][i - weight[j - 1]], dp[j - 1][i]);
				} else {
					dp[j][i] = dp[j - 1][i];
				}
			}
		}

		return dp[weight.length][size];
	}

	public static void main(String[] args) {
		System.out.println(getMaxValue(new int[] { 60, 100, 120 }, new int[] { 10, 20, 30 }, 50));
		System.out.println(getMaxValue(new int[] { 10, 40, 30, 50 }, new int[] { 5, 4, 6, 3 }, 10));
	}

}
