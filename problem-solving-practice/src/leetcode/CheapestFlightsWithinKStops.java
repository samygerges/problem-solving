package leetcode;

public class CheapestFlightsWithinKStops {

	public static void main(String[] args) {
		CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
		System.out.println(c.findCheapestPrice(5,
				new int[][] { { 0, 1, 5 }, { 1, 2, 5 }, { 0, 3, 2 }, { 3, 1, 2 }, { 1, 4, 1 }, { 4, 2, 1 } }, 0, 2, 2));
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int[][][] dp = new int[n][n][K + 1];
		int MAX_VALUE = 10000001;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k <= K; k++) {
					dp[i][j][k] = MAX_VALUE;
				}
			}
		}

		for (int i = 0; i < flights.length; i++) {
			dp[flights[i][0]][flights[i][1]][0] = flights[i][2];
		}

		for (int k = 1; k <= K; k++) {
			for (int i = 0; i < n; i++) {
				for (int r = 0; r < n; r++) {
					for (int j = 0; j < n; j++) {
						int left = 0, right = 0;
						if (k > 1) {
							left = k / 2;
							right = (k / 2) - 1;
						}
						dp[i][r][k] = Math.min(Math.min(dp[i][r][k], dp[i][r][k - 1]),
								Math.min(dp[i][j][left] + dp[j][r][right], dp[i][j][right] + dp[j][r][left]));
					}
				}
			}
		}

		return dp[src][dst][K] >= MAX_VALUE ? -1 : dp[src][dst][K];
	}
}
