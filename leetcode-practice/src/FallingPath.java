
public class FallingPath {

	public static int minFallingPathSum(int[][] A) {
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			int min = A[0][i] + getPath(A, 1, i);
			if (min < res)
				res = min;
		}
		return res;
	}

	private static int getPath(int[][] A, int row, int col) {
		if (row >= A.length || col >= A.length)
			return 0;

		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		int c = Integer.MAX_VALUE;

		a = getPath(A, row + 1, col) + A[row][col];
		b = getPath(A, row + 1, col + 1) + A[row][col];
		c = getPath(A, row + 1, col - 1) + A[row][col];

		return Math.min(a, Math.min(b, c));
	}

	public static void main(String[] args) {
		System.out.println(minFallingPathSum(new int[][] { { 17, 82 }, { 1, -44 } }));
	}

}
