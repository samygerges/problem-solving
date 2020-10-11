package leetcode;

public class MatrixBlockSum
{
	public int[][] matrixBlockSum(int[][] mat, int K) {
		int n = mat.length;
		int m = mat[0].length;
		int[][] answer = new int[n][m];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int r = Math.max(0, i - K); r <= Math.min(n - 1, i + K); r++) {
					for(int c = Math.max(0, j - K); c <= Math.min(m - 1, j + K); c++) {
						answer[i][j] += mat[r][c];
					}
				}
			}
		}
		return answer;
	}
}
