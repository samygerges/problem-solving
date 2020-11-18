package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals
{
	public int[][] merge(int[][] intervals)
	{
		Arrays.sort(intervals, (a, b) -> {
			if (a[0] < b[0])
			{
				return -1;
			}
			if (a[0] > b[0])
			{
				return 1;
			}
			return 0;
		});

		List<int[]> result = new ArrayList<>();
		if (intervals.length <= 1)
		{
			return intervals;
		}

		result.add(intervals[0]);
		int index = 0;
		for (int i = 1; i < intervals.length; i++)
		{
			if ((intervals[i][0] <= result.get(index)[1] && intervals[i][1] >= result.get(index)[1]) || (result.get(index)[0] <= intervals[i][1]
				&& result.get(index)[1] >= intervals[i][1]))
			{
				int[] interval = new int[2];
				interval[0] = Math.min(intervals[i][0], result.get(index)[0]);
				interval[1] = Math.max(intervals[i][1], result.get(index)[1]);
				result.remove(index);
				result.add(interval);
			}
			else
			{
				result.add(intervals[i]);
				index++;
			}
		}
		int[][] answer = new int[result.size()][2];
		for (int i = 0; i < result.size(); i++)
		{
			answer[i] = result.get(i);
		}
		return answer;
	}
}
