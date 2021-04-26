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

	private double calcHour(long num)
	{
		double res = (num * 1.0) / Math.pow(10, 9);
		return res / (60.0 * 60.0);
	}

	private double calcMin(long num)
	{
		double res = (num * 1.0) / Math.pow(10, 9);
		res /= 12.0;
		return res / 60.0;
	}

	private double calcSec(long num)
	{
		double res = (num * 1.0) / Math.pow(10, 9);
		res /= 720.0;
		return res / 60.0;
	}
}

