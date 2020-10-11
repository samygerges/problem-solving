package leetcode;

public class DiagonalSum
{
	public int diagonalSum(int[][] mat)
	{
		boolean[][] visited = new boolean[mat.length][mat.length];
		int sum = 0;
		for (int i = 0; i < mat.length; i++)
		{
			sum += mat[i][i];
			visited[i][i] = true;
		}

		int row = 0;
		for (int i = mat.length - 1; i >= 0; i--)
		{
			if (!visited[i][row])
			{
				sum += mat[i][row];
			}
			row++;
		}

		return sum;
	}
}
