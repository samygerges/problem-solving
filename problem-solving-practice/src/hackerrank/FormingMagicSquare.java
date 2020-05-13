package hackerrank;

public class FormingMagicSquare {
	public static void main(String[] args) {
		System.out.println(formingMagicSquare(new int[][] { { 5, 3, 4 }, { 1, 5, 8 }, { 6, 4, 2 } }));
	}

	static int formingMagicSquare(int[][] s) {
		int[][][] allMagicSquares = new int[][][] { { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } },
				{ { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } }, { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } },
				{ { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } }, { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } },
				{ { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } }, { { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } },
				{ { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } } };
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < allMagicSquares.length; i++) {
			int currentDiff = 0;
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					currentDiff += Math.abs(s[j][k] - allMagicSquares[i][j][k]);
				}
			}
			min = Math.min(currentDiff, min);
		}
		return min;
	}
}
