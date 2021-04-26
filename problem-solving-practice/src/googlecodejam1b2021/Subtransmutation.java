package googlecodejam1b2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Subtransmutation
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int n = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			int[] target = new int[21];
			int sum = 0;
			for (int j = 0; j < n; j++)
			{
				target[j + 1] = in.nextInt();
				sum += (target[j + 1] * (j + 1));
			}
			calculate(i, a, b, n, target, sum);
		}
		in.close();
	}

	private static void calculate(int t, int a, int b, int n, int[] target, int sum)
	{
		if (a > sum && b > sum)
		{
			System.out.println("Case #" + t + ": IMPOSSIBLE");
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 20; i++)
		{
			sb.append("0");
		}
		Map<String, Boolean> dp = new HashMap<>();
		for (int i = Math.min(a, b); i <= 400; i++)
		{
			int[] current = new int[21];
			if (i < current.length)
			{
				current[i]++;
				sb.setCharAt(i, '1');
			}

			if (calc(i, a, b, current, target, new HashMap<>(), sb.toString()))
			{
				System.out.println("Case #" + t + ": " + i);
				return;
			}
		}
		System.out.println("Case #" + t + ": IMPOSSIBLE");
	}

	private static boolean calc(int n, int a, int b, int[] current, int[] target, Map<String, Boolean> dp, String str)
	{
		if (n < 1)
		{
			return false;
		}
		if (checkMatch(current, target))
		{
			return true;
		}
		if (dp.containsKey(str))
		{
			return dp.get(str);
		}

		if (n - a > 0 && n - a < current.length)
		{
			current[n - a]++;
			str = str.substring(0, n - a) + current[n - a] + str.substring(n - a + 1);
		}
		if (n - b > 0 && n - b < current.length)
		{
			current[n - b]++;
			str = str.substring(0, n - b) + current[n - b] + str.substring(n - b + 1);
		}
		if (n < current.length)
		{
			current[n]--;
			str = str.substring(0, n) + current[n] + str.substring(n + 1);
		}
		boolean check =
			calc(n - a, a, b, Arrays.copyOf(current, current.length), target, dp, str) || calc(n - b, a, b, Arrays.copyOf(current, current.length),
				target, dp, str);
		dp.put(str, check);
		return check;
	}

	private static boolean checkMatch(int[] current, int[] target)
	{
		for (int i = 0; i < current.length; i++)
		{
			if (current[i] < target[i])
			{
				return false;
			}
		}
		return true;
	}
}

