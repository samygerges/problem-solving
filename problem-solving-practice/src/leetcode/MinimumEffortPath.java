package leetcode;

import java.util.PriorityQueue;

public class MinimumEffortPath
{
	public int minimumEffortPath(int[][] heights)
	{
		int n = heights.length;
		int m = heights[0].length;
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[0][0] = 0;
		int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.add(new int[] { 0, 0, 0 });
		while (!pq.isEmpty())
		{
			int[] p = pq.poll();
			int i = p[0], j = p[1];
			if (i == m - 1 && j == n - 1)
			{
				break;
			}
			for (int[] d : dir)
			{
				int x = i + d[0], y = j + d[1];
				if (x < 0 || x >= n || y < 0 || y >= m)
				{
					continue;
				}
				int alt = Math.max(p[2], Math.abs(heights[i][j] - heights[x][y]));
				if (alt < dp[x][y])
				{
					pq.add(new int[] { x, y, dp[x][y] = alt });
				}
			}
		}

		return dp[n - 1][m - 1];
	}
}
