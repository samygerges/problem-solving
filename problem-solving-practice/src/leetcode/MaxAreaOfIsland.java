package leetcode;

public class MaxAreaOfIsland
{
	private int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int maxAreaOfIsland(int[][] grid)
	{
		if (grid == null || grid.length == 0)
		{
			return 0;
		}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int max = 0;
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[i].length; j++)
			{
				if (grid[i][j] == 1)
				{
					max = Math.max(max, dfs(grid, visited, i, j));
				}
			}
		}
		return max;
	}

	private int dfs(int[][] grid, boolean[][] visited, int i, int j)
	{
		visited[i][j] = true;
		int res = 1;
		for (int k = 0; k < 4; k++)
		{
			if (i + dir[k][0] >= 0 && i + dir[k][0] < grid.length && j + dir[k][1] >= 0 && j + dir[k][1] < grid[i].length && !visited[i + dir[k][0]][j
				+ dir[k][1]] && grid[i + dir[k][0]][j + dir[k][1]] == 1)
			{
				res += dfs(grid, visited, i + dir[k][0], j + dir[k][1]);
			}
		}
		return res;
	}
}
