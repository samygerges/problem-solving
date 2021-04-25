package googlecodejam1b2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Template
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int count = calculate();
			System.out.println("Case #" + i + ": " + count);
		}
		in.close();
	}

	private static int calculate()
	{
		return 0;
	}
}

