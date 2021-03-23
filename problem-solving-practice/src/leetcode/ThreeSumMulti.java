package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumMulti
{
	public static void main(String[] args)
	{
		System.out.println(new ThreeSumMulti().threeSumMulti(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, 8));
	}

	public int threeSumMulti(int[] arr, int target)
	{
		int res = 0;
		Arrays.sort(arr);
		Map<Integer, Integer> start = new HashMap<>();
		Map<Integer, Integer> end = new HashMap<>();
		int index = 0;
		for (int i : arr)
		{
			start.putIfAbsent(i, index);
			end.put(i, index);
			index++;
		}
		for (int i = 0; i < arr.length - 1; i++)
		{
			for (int j = i + 1; j < arr.length; j++)
			{
				int value = target - (arr[i] + arr[j]);
				if (start.containsKey(value) && value >= arr[j] && end.get(value) > j)
				{
					int count = end.get(value) - start.get(value) + 1;
					if (value == arr[i])
					{
						count = end.get(value) - i;
					}
					if (value == arr[j])
					{
						count = end.get(value) - j;
					}
					if (count > 0)
					{
						res = (res + count) % 1_000_000_007;
					}
				}
			}
		}
		return res % 1_000_000_007;
	}
}
