package leetcode;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive
{
	public int firstMissingPositive(int[] nums)
	{
		Set<Integer> set = new HashSet<>();
		int max = 0;
		for (int i : nums)
		{
			if (i > 0)
			{
				set.add(i);
			}
			max = Math.max(max, i);
		}

		int res = -1;
		for (int i = 1; i <= max; i++)
		{
			if (!set.contains(i))
			{
				res = i;
				break;
			}
		}
		return res == -1 ? max + 1 : res;
	}
}
