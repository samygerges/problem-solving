package googlecodejam2021Qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Reversort
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++)
			{
				arr[j] = in.nextInt();
			}
			int count = calculate(i, arr);
			System.out.println("Case #" + i + ": " + count);
		}
		in.close();
	}

	private static int calculate(int t, int[] arr)
	{
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++)
		{
			int index = i;
			int min = arr[i];

			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[j] < min)
				{
					index = j;
					min = arr[j];
				}
			}
			count += index - i + 1;
			for (int j = i; j <= i + ((index - i) / 2); j++)
			{
				int tmp = arr[j];
				arr[j] = arr[index + i - j];
				arr[index + i - j] = tmp;
			}
		}
		return count;
	}

}

