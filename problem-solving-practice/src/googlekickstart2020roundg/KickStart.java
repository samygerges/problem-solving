package googlekickstart2020roundg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KickStart
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			String s = in.next();
			int count = solve(s);
			System.out.println("Case #" + i + ": " + count);
		}
		in.close();
	}

	private static int solve(String s)
	{
		if (s == null || s.isEmpty())
		{
			return 0;
		}
		int kicks = 0;
		int answer = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == 'K' && i + 3 < s.length())
			{
				if (s.charAt(i + 1) == 'I' && s.charAt(i + 2) == 'C' && s.charAt(i + 3) == 'K')
				{
					kicks++;
				}
			}
			else if (s.charAt(i) == 'S' && i + 4 < s.length())
			{
				if (s.charAt(i + 1) == 'T' && s.charAt(i + 2) == 'A' && s.charAt(i + 3) == 'R' && s.charAt(i + 4) == 'T')
				{
					answer += kicks;
				}
			}
		}
		return answer;
	}
}

