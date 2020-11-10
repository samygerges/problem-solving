package leetcode;

public class FlipAndInvertImage {
	public int[][] flipAndInvertImage(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			int n = A[i].length;
			n = n % 2 == 0 ? n / 2 : (n / 2) + 1;
			for (int j = 0; j < n; j++) {
				int tmp = A[i][j];
				A[i][j] = A[i][A[i].length - j - 1] == 0 ? 1 : 0;
				A[i][A[i].length - j - 1] = tmp == 0 ? 1 : 0;
			}
		}
		return A;
	}
}
