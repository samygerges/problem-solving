package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakesAndLadders
{
	public static void main(String[] args)
	{
		SnakesAndLadders s = new SnakesAndLadders();
		System.out.println(s.snakesAndLadders(
			new int[][] { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 35, -1, -1, 13, -1 },
			              { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } }));
	}

	public int snakesAndLadders(int[][] board)
	{
		int n = board.length;
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

	private int getNextPosition(int pos, int n)
	{
		int quot = (pos - 1) / n;
		int rem = (pos - 1) % n;
		int row = n - 1 - quot;
		int col = row % 2 != n % 2 ? rem : n - 1 - rem;
		return row * n + col;
	}
}
