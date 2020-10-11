package hackerrank;

import java.util.Arrays;

public class BikeRacers
{
	public static void main(String[] args)
	{
		System.out.println(bikeRacers(3, 3, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 } }, new int[][] { { 100, 1 }, { 200, 2 }, { 300, 3 } }, 2));
	}

	static long bikeRacers(int n, int m, int[][] bikers, int[][] bikes, int k)
	{
		double[][] dp = new double[n][m];
		for (int i = 0; i < bikers.length; i++)
		{
			for (int j = 0; j < bikes.length; j++)
			{
				dp[i][j] = Long.MAX_VALUE;
			}
		}
		for (int i = 0; i < bikers.length; i++)
		{
			for (int j = 0; j < bikes.length; j++)
			{
				dp[i][j] = Math.min(dp[i][j], Math.abs(bikers[i][0] - bikes[j][0]) + Math.abs(bikers[i][1] - bikes[j][1]));
			}
		}

		HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm(dp);

		int[] ind = hungarianAlgorithm.execute();
		long[] sums = new long[n];
		for (int i = 0; i < n; i++)
		{
			sums[i] = (long) dp[i][ind[i]];
		}

		Arrays.sort(sums);
		long sum = 0;
		for (int i = 0; i < k; i++)
		{
			sum = Math.max(sum, sums[i]);
		}
		return sum * sum;
	}
}
