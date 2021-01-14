package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumOperationsReduceXZero
{
	public static void main(String[] args)
	{
		System.out.println(new MinimumOperationsReduceXZero().minOperations(new int[] { 1, 1, 4, 2, 3 }, 5));
		System.out.println(new MinimumOperationsReduceXZero().minOperations(new int[] { 1, 1 }, 3));
		System.out.println(new MinimumOperationsReduceXZero().minOperations(new int[] { 1000, 1, 1, 2, 3 }, 1004));
	}

	public int minOperations(int[] nums, int x)
	{
		long X = x;
		Map<Long, List<Integer>> prefix = new HashMap<>();
		Map<Long, List<Integer>> suffix = new HashMap<>();
		int min = Integer.MAX_VALUE;
		long sum = 0;
		for (int i = 0; i < nums.length; i++)
		{
			sum += nums[i];
			prefix.putIfAbsent(sum, new ArrayList<>());
			prefix.get(sum).add(i);
		}

		sum = 0;
		for (int i = nums.length - 1; i >= 0; i--)
		{
			sum += nums[i];
			suffix.putIfAbsent(sum, new ArrayList<>());
			suffix.get(sum).add(i);
		}

		if (suffix.containsKey(X))
		{
			for (int i = 0; i < suffix.get(X).size(); i++)
			{
				min = Math.min(min, nums.length - suffix.get(X).get(i));
			}
		}
		if (prefix.containsKey(X))
		{
			for (int i = 0; i < prefix.get(X).size(); i++)
			{
				min = Math.min(min, prefix.get(X).get(i) + 1);
			}
		}

		for (long i : prefix.keySet())
		{
			if (suffix.containsKey(X - i))
			{
				for (int j = 0; j < prefix.get(i).size(); j++)
				{
					for (int k = 0; k < suffix.get(X - i).size(); k++)
					{
						if (prefix.get(i).get(j) < suffix.get(X - i).get(k))
						{
							min = Math.min(min, prefix.get(i).get(j) + 1 + (nums.length - suffix.get(X - i).get(k)));
						}
					}
				}
			}
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}
}
