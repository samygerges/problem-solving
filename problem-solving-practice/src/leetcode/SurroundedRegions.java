package leetcode;

public class SurroundedRegions
{
	private int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public void solve(char[][] board)
	{
		if (board == null || board.length == 0)
		{
			return;
		}
		boolean[][] arr = new boolean[board.length][board[0].length];
		boolean[][] infected = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++)
		{
			if (board[i][0] == 'O')
			{
				checkInfected(infected, board, i, 0);
			}
			if (board[i][board[i].length - 1] == 'O')
			{
				checkInfected(infected, board, i, board[i].length - 1);
			}
		}
		for (int i = 0; i < board[0].length; i++)
		{
			if (board[0][i] == 'O')
			{
				checkInfected(infected, board, 0, i);
			}
			if (board[board.length - 1][i] == 'O')
			{
				checkInfected(infected, board, board.length - 1, i);
			}
		}

		for (int i = 1; i < board.length - 1; i++)
		{
			for (int j = 1; j < board[i].length - 1; j++)
			{
				if (board[i][j] == 'O' && !infected[i][j])
				{
					boolean canFlip = true;
					for (int[] k : dir)
					{
						if (board[i + k[0]][j + k[1]] == 'O')
						{
							if (i + k[0] == 0 || j + k[1] == 0 || j + k[1] == board[j].length - 1 || i + k[0] == board.length - 1)
							{
								canFlip = false;
							}
							break;
						}
					}
					if (canFlip)
					{
						arr[i][j] = true;
					}
				}
			}
		}
		for (int i = 1; i < board.length - 1; i++)
		{
			for (int j = 1; j < board[i].length - 1; j++)
			{
				if (arr[i][j])
				{
					board[i][j] = 'X';
				}
			}
		}
	}

	private void checkInfected(boolean[][] infected, char[][] board, int sr, int sc)
	{
		infected[sr][sc] = true;
		for (int[] dir : dir)
		{
			if (sr + dir[0] < infected.length && sr + dir[0] > -1 && sc + dir[1] < infected[sr].length && sc + dir[1] > -1
				&& infected[sr + dir[0]][sc + dir[1]] == false && board[sr + dir[0]][sc + dir[1]] == 'O')
			{
				checkInfected(infected, board, sr + dir[0], sc + dir[1]);
			}
		}
	}
}
