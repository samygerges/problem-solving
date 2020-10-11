package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindWinnerOfArrayGame
{
	public static void main(String[] args)
	{
		System.out.println(new FindWinnerOfArrayGame().getWinner(new int[] { 1, 25, 35, 42, 68, 70 }, 2));
	}

	public int getWinner(int[] arr, int k)
	{
		int res = arr[0];
		int count = 0;
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i] > res)
			{
				count = 0;
				res = arr[i];
			}
			if (++count == k)
			{
				return res;
			}
		}
		return res;
	}

	public int getWinnerTLS(int[] arr, int k)
	{
		if (k > arr.length)
		{
			k = arr.length % k;
		}
		List<Integer> list = new ArrayList<>();
		for (int i : arr)
		{
			list.add(i);
		}

		int count = 0;
		int win = -1;
		while (count < k)
		{
			if (list.get(0) < list.get(1))
			{
				count = 1;
				int x = list.get(0);
				list.remove(0);
				list.add(x);
			}
			else
			{
				count++;
				int x = list.get(1);
				list.remove(1);
				list.add(x);
			}
		}

		return list.get(0);
	}
}
