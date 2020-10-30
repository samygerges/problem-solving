package src.leetcode;

import java.util.TreeSet;

public class ExamRoom
{
	private TreeSet<Integer> seats;
	private int n;

	public ExamRoom(int N)
	{
		seats = new TreeSet<>();
		n = N;
	}

	public int seat()
	{
		int index = 0;
		if (!seats.isEmpty())
		{
			int dist = seats.first();
			Integer prev = null;
			for (Integer s : seats)
			{
				if (prev != null)
				{
					int d = (s - prev) / 2;
					if (d > dist)
					{
						dist = d;
						index = prev + d;
					}
				}
				prev = s;
			}

			if (n - 1 - seats.last() > dist)
			{
				index = n - 1;
			}
		}
		seats.add(index);
		return index;
	}

	public void leave(int p)
	{
		seats.remove(p);
	}
}
