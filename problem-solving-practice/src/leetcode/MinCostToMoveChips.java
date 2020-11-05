package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinCostToMoveChips
{
	public static void main(String[] args)
	{
		System.out.println(new MinCostToMoveChips().minCostToMoveChips(
			new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 }));
		System.out.println(new MinCostToMoveChips().minCostToMoveChips(new int[] { 1, 3, 5, 3, 7, 2, 10, 1, 2, 2 }));
	}

	public int minCostToMoveChips(int[] position)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : position)
		{
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		List<Integer> keys = new ArrayList<>(map.keySet());
		for (int i = 0; i < keys.size(); i++)
		{
			for (int j = i + 1; j < keys.size(); j++)
			{
				if ((keys.get(j) - keys.get(i)) % 2 == 0)
				{
					map.put(keys.get(j), map.get(keys.get(j)) + map.get(keys.get(i)));
					map.remove(keys.get(i));
					break;
				}
			}
		}
		if (map.size() == 1)
		{
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int j : map.keySet())
		{
			min = Math.min(min, map.get(j));
		}
		return min;
	}

	public int minCostToMoveChipsOptimized(int[] position)
	{
		int even = 0;
		int odd = 0;
		for (int i : position)
		{
			if (i % 2 == 0)
			{
				even++;
			}
			else
			{
				odd++;
			}
		}
		return Math.min(even, odd);
	}
}
