package src.leetcode;

public class ChampagneTower
{
	public double champagneTower(int poured, int query_row, int query_glass)
	{
		double[][] arr = new double[query_row + 1][query_row + 1];
		arr[0][0] = poured;

		for (int i = 0; i < query_row; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				double remaining = (arr[i][j] * 1.0 - 1.0) / 2.0;
				if (remaining > 0)
				{
					arr[i + 1][j] += remaining;
					arr[i + 1][j + 1] += remaining;
				}
			}
		}
		return Math.min(1.0, arr[query_row][query_glass]);
	}
}
