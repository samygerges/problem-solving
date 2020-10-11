package leetcode;

import java.util.Arrays;

public class EraseOverlapIntervals
{
	public static void main(String[] args)
	{
		System.out.println(new EraseOverlapIntervals().eraseOverlapIntervals(new int[][] { { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 }, { 4, 6 } }));
	}

	public int eraseOverlapIntervals(int[][] intervals)
	{
		if (intervals == null || intervals.length == 0)
		{
			return 0;
		}
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));
		int count = 0;
		int index = 0;
		for (int i = 1; i < intervals.length; i++)
		{
			if (intervals[index][1] <= intervals[i][0])
			{
				index = i;
			}
			else
			{
				count++;
			}
		}
		return count;
	}
}
