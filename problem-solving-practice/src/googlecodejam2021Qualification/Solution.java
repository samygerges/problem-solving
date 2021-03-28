package googlecodejam2021Qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Solution
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int n = in.nextInt();
			int c = in.nextInt();
			calculate3(i, n, c);
		}
		in.close();
	}

	private static void calculate3(int t, int n, int c)
	{
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = i + 1;
		}
		List<List<Integer>> res = new ArrayList<>();
		permute(arr, new ArrayList<>(), res, 0);
		for (int i = 0; i < res.size(); i++)
		{
			Integer[] ans = new Integer[n];
			ans = res.get(i).toArray(ans);
			int cost = getCost(Arrays.copyOf(ans, n));
			if (cost == c)
			{
				StringJoiner joiner = new StringJoiner(" ");
				for (int k = 0; k < n; k++)
				{
					joiner.add(String.valueOf(ans[k]));
				}
				System.out.println("Case #" + t + ": " + joiner);
				return;
			}
		}
		System.out.println("Case #" + t + ": IMPOSSIBLE");
	}

	public static void permute(int[] nums, List<Integer> pre, List<List<Integer>> result, int len)
	{
		if (pre.size() == nums.length)
		{
			result.add(new ArrayList<>(pre));
			return;
		}

		ArrayList<Integer> prefix = new ArrayList<>(pre);
		for (int i = 0; i <= len; i++)
		{
			prefix.add(i, nums[len]);
			permute(nums, prefix, result, len + 1);
			prefix.remove(i);
		}
	}

	private static void calculate2(int t, int n, int c)
	{
		int total = c;
		if (c < n - 1)
		{
			System.out.println("Case #" + t + ": IMPOSSIBLE");
			return;
		}
		else
		{
			int[] arr = new int[n];

			int i = 0;
			int j = n - 1;
			boolean dir = true;
			for (int num = 1; num <= n; num++)
			{
				if (c > 1 && c > j + 1 && dir)
				{
					arr[j] = num;
					dir = false;
					j--;
					c -= j - i + 1;
				}
				else if (c > 1 && c > j + 1 && !dir)
				{
					arr[i] = num;
					dir = true;
					i++;
					c -= j - i + 1;
				}
				else
				{
					if (dir)
					{
						arr[i] = num;
						i++;
						c -= j - i + 1;
					}
					else
					{
						arr[j] = num;
						j--;
						c -= j - i + 1;
					}
				}
			}
			int cost = 0;//getCost(Arrays.copyOf(arr, n));
			if (total == cost)
			{
				StringJoiner joiner = new StringJoiner(" ");
				for (int k = 0; k < n; k++)
				{
					joiner.add(String.valueOf(arr[k]));
				}
				System.out.println("Case #" + t + ": " + joiner);
			}
			else
			{
				System.out.println("Case #" + t + ": IMPOSSIBLE");
				return;
			}
		}
	}

	private static int getCost(Integer[] arr)
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

