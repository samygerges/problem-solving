package leetcode;

public class LongestIncreasingPath
{

	public static void main(String[] args)
	{
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } }));
	}

	private static int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int longestIncreasingPath(int[][] matrix)
	{
		if (matrix == null || matrix.length == 0)
		{
			return 0;
		}
		int max = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				max = Math.max(max, dfs(matrix, i, j, dp));
			}
		}
		return max;
	}

	private int dfs(int[][] matrix, int x, int y, int[][] dp)
	{
		if (dp[x][y] != 0)
		{
			return dp[x][y];
		}
		dp[x][y] = 1;
		for (int[] d : dir)
		{
			if (d[0] + x < matrix.length && d[0] + x >= 0 && d[1] + y < matrix[x].length && d[1] + y >= 0 && matrix[x][y] < matrix[x + d[0]][y
				+ d[1]])
			{
				dp[x][y] = Math.max(dp[x][y], 1 + dfs(matrix, x + d[0], y + d[1], dp));
			}
		}
		return dp[x][y];
	}
}
