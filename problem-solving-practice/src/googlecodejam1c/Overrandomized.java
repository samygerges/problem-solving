package googlecodejam1c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Overrandomized
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			String direction = in.next();
			calculate(i, x, y, direction);
		}
		in.close();
	}

	private static void calculate(int t, int x, int y, String direction)
	{

	}
}
