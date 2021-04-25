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
			int x = in.nextInt();
			int y = in.nextInt();
			String s = in.next();

			int count = calculate(i, x, y, s);
			System.out.println("Case #" + i + ": " + count);
		}
		in.close();
	}

	private static int calculate(int t, int x, int y, String s)
	{
		if (s.length() == 1)
		{
			return 0;
		}
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == '?')
			{
				if (i == 0 && i + 1 < arr.length)
				{
					if (x < 0 && x < y && (arr[i + 1] == 'J' || arr[i + 1] == '?'))
					{
						arr[i] = 'C';
					}
					else if (y < 0 && y < x && (arr[i + 1] == 'C' || arr[i + 1] == '?'))
					{
						arr[i] = 'J';
					}
					else
					{
						arr[i] = arr[i + 1];
					}
				}
				else if (i + 1 == arr.length && i - 1 >= 0)
				{
					if (x < 0 && x < y && (arr[i - 1] == 'J' || arr[i - 1] == '?'))
					{
						arr[i] = 'J';
					}
					else if (y < 0 && y < x && (arr[i - 1] == 'C' || arr[i - 1] == '?'))
					{
						arr[i] = 'C';
					}
					else
					{
						arr[i] = arr[i - 1];
					}
				}
				else if (arr[i] == '?')
				{
					if (x < y && x < 0 && (arr[i - 1] == 'C' || arr[i - 1] == '?'))
					{
						arr[i] = 'J';
					}
					else if (x < y && x < 0 && (arr[i + 1] == 'J' || arr[i + 1] == '?'))
					{
						arr[i] = 'C';
					}
					else if (y < x && y < 0 && (arr[i - 1] == 'J' || arr[i - 1] == '?'))
					{
						arr[i] = 'C';
					}
					else if (y < x && y < 0 && (arr[i + 1] == 'C' || arr[i + 1] == '?'))
					{
						arr[i] = 'J';
					}
					else
					{
						arr[i] = arr[i - 1];
					}
				}
			}
		}
		return calc(arr, x, y);
	}

	private static int calc(char[] arr, int x, int y)
	{
		int cost = 0;
		for (int i = 0; i < arr.length - 1; i++)
		{
			if (arr[i] == 'C' && arr[i + 1] == 'J')
			{
				cost += x;
			}
			else if (arr[i] == 'J' && arr[i + 1] == 'C')
			{
				cost += y;
			}
		}
		return cost;
	}

}

