package leetcode;

public class MaximalSquare
{
	public static void main(String[] args)
	{
		System.out.println(maximalSquare(
			new char[][] { { '1', '0', '1', '1', '1', '0', '0', '0', '1', '0' }, { '0', '1', '0', '0', '0', '0', '0', '1', '1', '0' },
			               { '0', '1', '0', '1', '0', '0', '0', '0', '1', '1' }, { '1', '1', '1', '0', '0', '0', '0', '0', '1', '0' },
			               { '0', '1', '1', '1', '0', '0', '1', '0', '1', '0' }, { '1', '1', '0', '1', '1', '0', '1', '1', '1', '0' } }));
		System.out.println(maximalSquare(new char[][] { { '1', '1', '1', '1', '1', '1', '1', '1' }, { '1', '1', '1', '1', '1', '1', '1', '0' },
		                                                { '1', '1', '1', '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '1', '0', '0', '0' },
		                                                { '0', '1', '1', '1', '1', '0', '0', '0' } }));
	}

	public static int maximalSquare(char[][] matrix)
	{
		int max = 0;
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j] == '1')
				{
					// check other square length
					int max_row = i;
					int max_column = j;
					while (max_row + 1 < matrix.length && max_column + 1 < matrix[i].length)
					{
						if (matrix[max_row + 1][max_column + 1] == '1')
						{
							max_row++;
							max_column++;
						}
						else
						{
							break;
						}
					}
					for (int k = i; k <= max_row; k++)
					{
						for (int r = j; r <= max_column; r++)
						{
							if (matrix[k][r] == '0')
							{
								int diff = max_row - k < max_column - r ? (max_row - k) + 1 : (max_column - r) + 1;
								max_row -= diff;
								max_column -= diff;
								break;
							}
						}
					}
					max = Math.max((max_row - i + 1) * (max_column - j + 1), max);
				}
			}
		}
		return max;
	}

	public static int maximalSquareDP(char[][] matrix)
	{
		int max = 0;
		if (matrix == null || matrix.length == 0)
		{
			return max;
		}
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j] == '1')
				{
					dp[i][j] = 1;
					if (i > 0 && j > 0)
					{
						dp[i][j] += Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
					}
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max * max;
	}
}
