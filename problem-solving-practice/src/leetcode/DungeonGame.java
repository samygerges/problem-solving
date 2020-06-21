package leetcode;

public class DungeonGame {

	public static void main(String[] args) {
		DungeonGame a = new DungeonGame();
		System.out.println(a.calculateMinimumHP(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } }));
		System.out.println(a.calculateMinimumHP(new int[][] { { 1, -3, 3 }, { 0, -2, 0 }, { -3, -3, -3 } }));
	}

	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0) {
			return 0;
		}
		int n = dungeon.length;
		int m = dungeon[0].length;
		int[][] dp = new int[n][m];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (i + 1 == n && j + 1 == m) {
					dp[i][j] = Math.max(-dungeon[i][j] + 1, 1);
				} else if (i + 1 == n) {
					dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
				} else if (j + 1 == m) {
					dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
				} else {
					int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
					int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
					dp[i][j] = Math.min(right, down);
				}
			}
		}

		return dp[0][0];
	}
}
