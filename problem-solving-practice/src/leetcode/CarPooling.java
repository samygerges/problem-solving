package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CarPooling
{
	public static void main(String[] args)
	{
		System.out.println(new CarPooling().carPooling(new int[][] { { 9, 3, 6 }, { 8, 1, 7 }, { 6, 6, 8 }, { 8, 4, 9 }, { 4, 2, 9 } }, 28));
	}

	public boolean carPooling(int[][] trips, int capacity)
	{
		int[] travel = new int[1001];
		for (int[] i : trips)
		{
			travel[i[1]] += i[0];
			travel[i[2]] -= i[0];
		}
		if (travel[0] > capacity)
		{
			return false;
		}
		for (int i = 1; i < 10001; i++)
		{
			travel[i] += travel[i - 1];
			if (travel[i] > capacity)
			{
				return false;
			}
		}
		return true;
	}

	public boolean carPoolingWrongAnswer(int[][] trips, int capacity)
	{
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		queue.addAll(Arrays.asList(trips));

		int currentCap = 0;
		int start = -1;
		int end = -1;
		while (!queue.isEmpty())
		{
			int[] trip = queue.poll();
			if (trip[1] >= end)
			{
				start = trip[1];
				end = trip[2];
				if (trip[0] > capacity)
				{
					return false;
				}
				currentCap = trip[0];
			}
			else
			{
				if (currentCap + trip[0] > capacity)
				{
					return false;
				}

				int[] trip1 = new int[] { trip[0] + currentCap, Math.max(start, trip[1]), Math.min(end, trip[2]) };
				int[] trip2 = new int[] { trip[0], end, trip[2] };
				end = trip[1];
				queue.add(trip1);
				queue.add(trip2);
			}
		}
		return true;
	}
}
