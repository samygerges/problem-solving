package googlecodejam1a2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution
{
	public static void main(String[] args)
	{
		calculate(new String[] { "*CONUTS", "*COCONUTS", "*OCONUTS", "*CONUTS", "*S" }, 1);
		calculate(new String[] { "*XZ", "*XYZ" }, 2);
		calculate(new String[] { "H*O", "HELLO*", "*HELLO", "HE*" }, 3);
		calculate(new String[] { "CO*DE", "J*AM" }, 4);
		calculate(new String[] { "CODE*", "*JAM" }, 5);
		calculate(new String[] { "A*C*E", "*B*D*" }, 6);
		calculate(new String[] { "A*C*E", "*B*D" }, 7);
		calculate(new String[] { "**Q**", "*A*" }, 8);

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		List<String[]> all = new ArrayList<>();
		for (int i = 1; i <= t; ++i)
		{
			int n = in.nextInt();
			String[] patterns = new String[n];
			for (int j = 0; j < n; j++)
			{
				patterns[j] = in.next();
			}
			all.add(patterns);
		}
		for (int i = 0; i < all.size(); i++)
		{
			calculate(all.get(i), i + 1);
		}
		in.close();
	}

	private static void calculate(String[] patterns, int testCase)
	{
		List<List<String>> all = new ArrayList<>();
		for (int i = 0; i < patterns.length; i++)
		{
			String[] pattern = patterns[i].split("\\*");
			List<String> patternList = Arrays.stream(pattern).collect(Collectors.toList());
			if (patterns[i].endsWith("*"))
			{
				patternList.add("");
			}
			all.add(patternList);
		}

		String start = "";
		String mid = "";
		String end = "";

		for (int i = 0; i < all.size(); i++)
		{
			if (start.contains(all.get(i).get(0)))
			{
			}
			else if (all.get(i).get(0).contains(start))
			{
				start = all.get(i).get(0);
			}
			else
			{
				System.out.println("Case #" + testCase + ": *");
				return;
			}

			if (end.contains(all.get(i).get(all.get(i).size() - 1)))
			{
			}
			else if (all.get(i).get(all.get(i).size() - 1).contains(end))
			{
				end = all.get(i).get(all.get(i).size() - 1);
			}
			else
			{
				System.out.println("Case #" + testCase + ": *");
				return;
			}

			for (int j = 1; j < all.get(i).size() - 1; j++)
			{
				if (mid.contains(all.get(i).get(j)))
				{
				}
				else if (all.get(i).get(j).contains(mid))
				{
					mid = all.get(i).get(j);
				}
				else
				{
					mid += all.get(i).get(j);
				}
			}

		}
		String result = start + mid + end;
		result = result.length() > 10000 ? "*" : result;
		System.out.println("Case #" + testCase + ": " + result);
	}
}
