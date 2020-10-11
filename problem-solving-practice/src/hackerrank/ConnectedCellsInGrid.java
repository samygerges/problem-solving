package hackerrank;

public class ConnectedCellsInGrid
{
	private static int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { 1, -1 }, { -1, 0 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	static int connectedCell(int[][] matrix)
	{
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		int max = 0;
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j] == 1)
				{
					int currentRegion = dfs(matrix, i, j, visited);
					max = Math.max(max, currentRegion);
				}
			}
		}
		return max;
	}

	private static int dfs(int[][] matrix, int i, int j, boolean[][] visited)
	{
		visited[i][j] = true;
		int region = 1;
		for (int[] dir : directions)
		{
			if (i + dir[0] > -1 && i + dir[0] < matrix.length && j + dir[1] > -1 && j + dir[1] < matrix[i].length && !visited[i + dir[0]][j + dir[1]]
				&& matrix[i + dir[0]][j + dir[1]] == 1)
			{
				region += dfs(matrix, i + dir[0], j + dir[1], visited);
			}
		}
		return region;
	}
}
