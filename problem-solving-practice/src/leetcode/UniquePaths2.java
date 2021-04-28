package leetcode;

public class UniquePaths2
{
	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		if (obstacleGrid == null || obstacleGrid.length == 0)
		{
			return 0;
		}
		boolean visited[][] = new boolean[obstacleGrid.length][obstacleGrid[0].length];
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		return countPaths(obstacleGrid, 0, 0, obstacleGrid.length, obstacleGrid[0].length, dp);
	}

	private int countPaths(int[][] grid, int r, int c, int lenR, int lenC, int[][] dp)
	{
		if (grid[r][c] == 1)
		{
			return 0;
		}
		if (r + 1 == lenR && c + 1 == lenC && grid[r][c] != 1)
		{
			return 1;
		}
		if (dp[r][c] != 0)
		{
			return dp[r][c];
		}

		if (r + 1 < lenR && grid[r + 1][c] != 1)
		{
			dp[r][c] += countPaths(grid, r + 1, c, lenR, lenC, dp);
		}
		if (c + 1 < lenC && grid[r][c + 1] != 1)
		{
			dp[r][c] += countPaths(grid, r, c + 1, lenR, lenC, dp);
		}
		return dp[r][c];
	}
}
