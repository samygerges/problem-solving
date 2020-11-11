package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSquare
{
	public static void main(String[] args)
	{
		System.out.println(new ValidSquare().validSquare(new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, 1 }, new int[] { 0, -1 }));
	}
	
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4)
	{
		Set<Long> set = new HashSet<>();
		int[][] arr = { p1, p2, p3, p4 };
		for (int i = 0; i < 4; i++)
		{
			for (int j = i + 1; j < 4; j++)
			{
				int x = arr[i][0] - arr[j][0];
				int y = arr[i][1] - arr[j][1];
				long l = x * x + y * y;
				if (l == 0)
				{
					return false;
				}
				set.add(l);
				if (set.size() > 2)
				{
					return false;
				}
			}
		}

		return true;
	}
}
