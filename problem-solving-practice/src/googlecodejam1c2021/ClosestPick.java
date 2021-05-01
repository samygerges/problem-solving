package googlecodejam1c2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class ClosestPick
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int n = in.nextInt();
			int range = in.nextInt();
			int[] p = new int[n];
			for (int j = 0; j < n; j++)
			{
				p[j] = in.nextInt();
			}
			double res = calculate2(range, p);
			System.out.println("Case #" + i + ": " + res);
		}
		in.close();
	}

	private static double calculate(int range, int[] p)
	{
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		Arrays.sort(p);
		int r3 = 0;
		for (int i = 1; i < p.length; i++)
		{
			list.add((p[i] - p[i - 1]) / 2);
			r3 = Math.max(r3, p[i] - p[i - 1] - 1);
		}
		list.add(p[0] - 1);
		list.add(range - p[p.length - 1]);

		Collections.sort(list);
		int r1 = list.get(list.size() - 1);
		int r2 = list.get(list.size() - 2);
		int max = Math.max(r1 + r2, r3);
		return (max * 1.0) / (range * 1.0);
	}
}

