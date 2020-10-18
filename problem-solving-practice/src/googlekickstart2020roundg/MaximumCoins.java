package googlekickstart2020roundg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MaximumCoins
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int n = in.nextInt();
			long[][] arr = new long[n][n];
			for (int j = 0; j < n; j++)
			{
				for (int k = 0; k < n; k++)
				{
					arr[j][k] = in.nextLong();
				}
			}
			long count = solve(n, arr);
			System.out.println("Case #" + i + ": " + count);
		}
		in.close();
	}

	private static long solve(int n, long[][] arr)
	{
		long[][] dp = new long[n][n];
		for (int i = 0; i < n; i++)
		{
			dp[0][i] = arr[0][i];
			dp[i][0] = arr[i][0];
		}
		for (int i = 1; i < n; i++)
		{
			for (int j = 1; j < n; j++)
			{
				dp[i][j] = arr[i][j] + dp[i - 1][j - 1];
			}
		}
		long max = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
}

