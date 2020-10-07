package leetcode;

public class RestoreMatrix {

	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
		int n = rowSum.length;
		int m = colSum.length;
		int[][] matrix = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Math.min(rowSum[i], colSum[j]);
				rowSum[i] -= matrix[i][j];
				colSum[j] -= matrix[i][j];
			}
		}

		return matrix;
	}
}
