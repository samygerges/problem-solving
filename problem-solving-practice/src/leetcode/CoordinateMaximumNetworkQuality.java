package src.leetcode;

import java.util.Arrays;

public class CoordinateMaximumNetworkQuality
{
	public static void main(String[] args)
	{
		int[] a = new CoordinateMaximumNetworkQuality().bestCoordinate(new int[][] { { 1, 2, 5 }, { 2, 1, 7 }, { 3, 1, 9 } }, 2);
		System.out.println("[" + a[0] + "," + a[1] + "]");
	}

	public int[] bestCoordinate(int[][] towers, int radius)
	{
		Arrays.sort(towers, (a, b) -> {
			if (a[0] == b[0])
			{
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});
		int[] answer = new int[2];
		int best = 0;
		for (int i = 0; i <= 50; i++)
		{
			for (int j = 0; j <= 50; j++)
			{
				int sum = 0;
				for (int k = 0; k < towers.length; k++)
				{
					int dist = sqrDis(towers[k][0] - i, towers[k][1] - j);
					if (dist <= radius * radius)
					{
						sum += (int)((towers[k][2] * 1.0) / (1.0 + dis(towers[k][0] - i, towers[k][1] - j)));
					}
				}
				if (sum > best)
				{
					best = sum;
					answer[0] = i;
					answer[1] = j;
				}
			}
		}
		return answer;
	}

	private double dis(int dx, int dy)
	{
		return Math.sqrt(dx * dx + dy * dy);
	}

	private int sqrDis(int dx, int dy)
	{
		return dx * dx + dy * dy;
	}
}
