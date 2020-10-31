package leetcode;

import java.util.Arrays;

public class MaxWidthOfVerticalArea
{
	public int maxWidthOfVerticalArea(int[][] points)
	{
		Arrays.sort(points, (a, b) -> {
			if (a[0] == b[0])
			{
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});

		int max = 0;
		for (int i = 0; i < points.length - 1; i++)
		{
			max = Math.max(points[i + 1][0] - points[i][0], max);
		}
		return max;
	}
}
