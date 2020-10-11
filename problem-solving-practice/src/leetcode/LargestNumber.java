package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LargestNumber
{
	public static void main(String[] args)
	{
		System.out.println(new LargestNumber().largestNumber(new int[] { 2, 4, 6, 2, 4, 6, 4, 4, 4 }, 5));
		System.out.println(new LargestNumber().largestNumber(new int[] { 1, 1, 1, 1, 1, 1, 1, 3, 2 }, 10));
	}

	Map<Integer, String> cache = new HashMap<>();

	public String largestNumber(int[] cost, int target)
	{
		if (target == 0)
		{
			return "";
		}
		if (cache.containsKey(target))
		{
			return cache.get(target);
		}

		Map<Integer, String> map = new HashMap<>();
		for (int i = cost.length - 1; i > -1; i--)
		{
			String res = "";
			if (target - cost[i] >= 0)
			{
				res += "" + (i + 1);
				res += largestNumber(cost, target - cost[i]);
				if (!res.contains("0") && !map.containsKey(res.length()))
				{
					map.put(res.length(), res);
				}
			}
		}
		int maxLen = 0;
		String res = "0";
		for (int i : map.keySet())
		{
			if (i > maxLen)
			{
				res = map.get(i);
				maxLen = i;
			}
		}
		cache.put(target, res);
		return res;
	}
}
