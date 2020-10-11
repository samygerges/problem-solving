package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps2
{
	public static void main(String[] args)
	{
		System.out.println(minimumSwaps(new int[] { 1, 3, 5, 2, 4, 6, 7 }));
	}

	static int minimumSwaps(int[] arr)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++)
		{
			map.put(arr[i], i);
		}

		int swaps = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] != i + 1)
			{
				int j = map.get(i + 1);
				map.put(arr[i], j);
				map.put(arr[j], i);
				swap(arr, i, j);
				swaps++;
			}
		}

		return swaps;
	}

	private static void swap(int[] arr, int i, int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
