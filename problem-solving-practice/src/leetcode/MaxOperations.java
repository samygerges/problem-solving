package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxOperations
{
	public static void main(String[] args)
	{
		System.out.println(new MaxOperations().maxOperations(new int[] { 3, 1, 3, 4, 3 }, 6));
	}

	public int maxOperations(int[] nums, int k)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums)
		{
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int count = 0;
		for (int i : map.keySet())
		{
			while (map.get(i) > 0)
			{
				map.put(i, map.get(i) - 1);
				if (map.containsKey(k - i) && map.get(k - i) > 0)
				{
					count++;
					map.put(k - i, map.get(k - i) - 1);
				}
			}
		}
		return count;
	}
}
