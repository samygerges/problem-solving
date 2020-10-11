package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakesLadders
{
	static int quickestWayUp(int[][] ladders, int[][] snakes)
	{
		int n = 10;
		int[][] board = new int[n][n];
		for (int i = 0; i < board.length; i++)
		{
			Arrays.fill(board[i], -1);
		}
		for (int i = 0; i < ladders.length; i++)
		{
			int pos = getNextPosition(ladders[i][0], n);
			int r = pos / n;
			int c = pos % n;
			board[r][c] = ladders[i][1];
		}

		for (int i = 0; i < snakes.length; i++)
		{
			int pos = getNextPosition(snakes[i][0], n);
			int r = pos / n;
			int c = pos % n;
			board[r][c] = snakes[i][1];
		}

		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 0);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		while (!queue.isEmpty())
		{
			int pos = queue.remove();
			if (pos == n * n)
			{
				return map.get(pos);
			}

			for (int i = pos + 1; i <= Math.min(n * n, pos + 6); i++)
			{
				int next = getNextPosition(i, n);
				int r = next / n;
				int c = next % n;
				int nextPos = board[r][c] == -1 ? i : board[r][c];
				if (!map.containsKey(nextPos))
				{
					map.put(nextPos, map.get(pos) + 1);
					queue.add(nextPos);
				}
			}
		}

		return -1;
	}

	private static int getNextPosition(int pos, int n)
	{
		int quot = (pos - 1) / n;
		int rem = (pos - 1) % n;
		int row = n - 1 - quot;
		int col = row % 2 != n % 2 ? rem : n - 1 - rem;
		return row * n + col;
	}
}
