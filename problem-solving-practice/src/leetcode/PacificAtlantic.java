package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PacificAtlantic
{
	public List<List<Integer>> pacificAtlantic(int[][] matrix)
	{
		if (matrix == null || matrix.length == 0)
		{
			return Collections.emptyList();
		}

		int n = matrix.length;
		int m = matrix[0].length;

		ArrayDeque<int[]> pacific = new ArrayDeque<>();
		ArrayDeque<int[]> atlantic = new ArrayDeque<>();

		for (int i = 0; i < n; i++)
		{
			pacific.add(new int[] { i, 0 });
			atlantic.add(new int[] { i, m - 1 });
		}

		for (int i = 0; i < m; i++)
		{
			pacific.add(new int[] { 0, i });
			atlantic.add(new int[] { n - 1, i });
		}

		boolean[][] pacificPoints = bfs(pacific, n, m, matrix);
		boolean[][] atlanticPoints = bfs(atlantic, n, m, matrix);

		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (pacificPoints[i][j] && atlanticPoints[i][j])
				{
					res.add(Arrays.asList(i, j));
				}
			}
		}
		return res;
	}

	private boolean[][] bfs(ArrayDeque<int[]> queue, int n, int m, int[][] matrix)
	{
		int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		boolean[][] res = new boolean[n][m];
		while (!queue.isEmpty())
		{
			int[] point = queue.poll();
			res[point[0]][point[1]] = true;
			for (int i = 0; i < 4; i++)
			{
				int x = point[0] + dir[i][0];
				int y = point[1] + dir[i][1];
				if (x >= 0 && x < n && y >= 0 && y < m && !res[x][y] && matrix[point[0]][point[1]] <= matrix[x][y])
				{
					queue.add(new int[] { x, y });
				}
			}
		}
		return res;
	}
}
