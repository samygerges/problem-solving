package leetcode;

public class CountSquares {

	public static void main(String[] args) {
		System.out.println(
				new CountSquares().countSquares(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } }));
	}

	public int countSquares(int[][] matrix) {
		int count = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					dp[i][j] = 1;
					if (i > 0 && j > 0) {
						dp[i][j] += Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
					}
				}
				count += dp[i][j];
			}
		}
		return count;
	}
}
