package leetcode;

public class UniquePathsIII {

	public static void main(String[] args) {
		System.out.println(
				new UniquePathsIII().uniquePathsIII(new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } }));
	}

	public int uniquePathsIII(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		int zeros = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					x = i;
					y = j;
				} else if (grid[i][j] == 0) {
					zeros++;
				}
			}
		}

		return dfs(grid, n, m, x, y, zeros);
	}

	int[][] dir = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	private int dfs(int[][] grid, int n, int m, int x, int y, int zeros) {
		if (x >= n || x < 0 || y >= m || y < 0 || grid[x][y] == -1) {
			return 0;
		}
		if (grid[x][y] == 2) {
			return zeros == -1 ? 1 : 0;
		}

		int ways = 0;

		grid[x][y] = -1;
		zeros--;
		for (int k = 0; k < 4; k++) {
			ways += dfs(grid, n, m, x + dir[k][0], y + dir[k][1], zeros);
		}
		grid[x][y] = 0;
		return ways;
	}
}
