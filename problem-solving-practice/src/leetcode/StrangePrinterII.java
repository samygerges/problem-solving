package leetcode;

import java.util.Arrays;

public class StrangePrinterII {
	public boolean isPrintable(int[][] targetGrid) {
		int[] minRow = new int[61];
		int[] minCol = new int[61];
		int[] maxRow = new int[61];
		int[] maxCol = new int[61];

		Arrays.fill(maxRow, -1);
		Arrays.fill(maxCol, -1);
		Arrays.fill(minRow, Integer.MAX_VALUE);
		Arrays.fill(minCol, Integer.MAX_VALUE);

		int n = targetGrid.length;
		int m = targetGrid[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int color = targetGrid[i][j];
				minRow[color] = Math.min(minRow[color], i);
				minCol[color] = Math.min(minCol[color], j);
				maxRow[color] = Math.max(maxRow[color], i);
				maxCol[color] = Math.max(maxCol[color], j);
			}
		}

		while (true) {
			boolean removed = false;
			boolean anything = false;
			for (int i = 1; i < 61; i++) {
				if (maxRow[i] == -1) {
					continue;
				}
				anything = true;
				boolean check = true;
				for (int r = minRow[i]; check && r <= maxRow[i]; r++) {
					for (int c = minCol[i]; c <= maxCol[i]; c++) {
						if (targetGrid[r][c] != i && targetGrid[r][c] != 0) {
							check = false;
							break;
						}
					}
				}
				if (check) {
					removed = true;
					for (int r = minRow[i]; r <= maxRow[i]; r++) {
						for (int c = minCol[i]; c <= maxCol[i]; c++) {
							targetGrid[r][c] = 0;
						}
					}
					maxRow[i] = -1;
				}
			}
			if (!anything) {
				return true;
			}
			if (!removed) {
				return false;
			}
		}
	}
}
