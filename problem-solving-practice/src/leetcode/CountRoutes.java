package leetcode;

public class CountRoutes {

	public int countRoutes(int[] locations, int start, int finish, int fuel) {
		int mod = (int) 1e9 + 7;
		int n = locations.length;
		int[][] dp = new int[n][fuel + 1];
		dp[start][fuel] = 1;

		for (int f = fuel; f >= 1; f--) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int dist = Math.abs(locations[i] - locations[j]);
					if (i != j && dist <= f) {
						dp[j][f - dist] = (dp[j][f - dist] + dp[i][f]) % mod;
					}
				}
			}
		}

		int answer = 0;
		for (int i = 0; i <= fuel; i++) {
			answer = (answer + dp[finish][i]) % mod;
		}
		return answer;
	}
}
