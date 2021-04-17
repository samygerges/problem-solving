package leetcode;

public class CountPoints
{
	public static void main(String[] args)
	{
		System.out.println(new CountPoints().countPoints(new int[][] { { 1, 3 }, { 3, 3 }, { 5, 3 }, { 2, 2 } },
			new int[][] { { 2, 3, 1 }, { 4, 3, 1 }, { 1, 1, 2 } }));
	}

	public int[] countPoints(int[][] points, int[][] queries)
	{
		int[] res = new int[queries.length];
		for (int i = 0; i < queries.length; i++)
		{
			int x = queries[i][0];
			int y = queries[i][1];
			int r = queries[i][2];
			for (int[] point : points)
			{
				int px = x - point[0];
				int py = y - point[1];
				if (px * px + py * py <= r * r)
				{
					res[i]++;
				}
			}
		}
		return res;
	}
}
