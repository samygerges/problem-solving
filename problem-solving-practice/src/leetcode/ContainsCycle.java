package leetcode;

public class ContainsCycle
{
	public boolean containsCycle(char[][] grid)
	{
		int N = grid.length;
		int M = grid[0].length;
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{
				visited[i][j] = false;
			}
		}

		boolean cycle = false;

		for (int i = 0; i < N; i++)
		{
			if (cycle)
			{
				break;
			}

			for (int j = 0; j < M; j++)
			{
				if (!visited[i][j])
				{
					cycle = isCycle(i, j, grid, visited, -1, -1, N, M);
				}
				if (cycle)
				{
					break;
				}
			}
		}
		return cycle;
	}

	int directionInX[] = new int[] { -1, 0, 1, 0 };
	int directionInY[] = new int[] { 0, 1, 0, -1 };

	boolean isValid(int x, int y, int N, int M)
	{
		if (x < N && x >= 0 && y < M && y >= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	boolean isCycle(int x, int y, char arr[][], boolean visited[][], int parentX, int parentY, int N, int M)
	{
		visited[x][y] = true;

		for (int k = 0; k < 4; k++)
		{
			int newX = x + directionInX[k];
			int newY = y + directionInY[k];

			if (isValid(newX, newY, N, M) && arr[newX][newY] == arr[x][y] && !(parentX == newX && parentY == newY))
			{
				if (visited[newX][newY])
				{
					return true;
				}

				else
				{
					boolean check = isCycle(newX, newY, arr, visited, x, y, N, M);
					if (check)
					{
						return true;
					}
				}
			}
		}

		return false;
	}
}
