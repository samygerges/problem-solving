package src.googlekickstart2020roundg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class CombinationLock
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int n = in.nextInt();
			int w = in.nextInt();
			long[] arr = new long[n];
			for (int j = 0; j < n; j++)
			{
				arr[j] = in.nextLong();
			}
			long count = solve(n, w, arr);
			System.out.println("Case #" + i + ": " + count);
		}
		in.close();
	}

	private static long solve(int n, int w, long[] arr)
	{
		Arrays.sort(arr);
		long diff = Long.MAX_VALUE;

		for (int j = 0; j < arr.length; j++)
		{
			long check = 0;
			for (int i = 0; i < arr.length; i++)
			{
				long tmp = Math.min(arr[i] + (w - arr[j]), w - arr[i] + arr[j]);
				check += Math.min(Math.abs(arr[i] - arr[j]), tmp);
			}
			diff = Math.min(diff, check);
		}
		return diff;
	}
}

