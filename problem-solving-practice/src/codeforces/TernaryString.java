package codeforces;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TernaryString
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = in.nextInt();
		for (int i = 0; i < t; i++)
		{
			solve(i, in, out);
		}
		in.close();
		out.close();
	}

	public static void solve(int testNumber, Scanner in, PrintWriter out)
	{
		String s = in.next();
		int inf = 2000000;
		int one = inf;
		int two = inf;
		int three = inf;
		int answer = inf;

		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '1')
			{
				one = i;
			}
			if (s.charAt(i) == '2')
			{
				two = i;
			}
			if (s.charAt(i) == '3')
			{
				three = i;
			}
			answer = Math.min(answer, Math.max(one, Math.max(two, three)) - Math.min(one, Math.min(two, three)) + 1);
		}
		out.println(answer > 200000 ? 0 : answer);
	}
}
