package leetcode;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies2
{
	public int distributeCandies(int[] candyType)
	{
		int n = candyType.length;
		int maxToEat = n / 2;
		int types = 0;
		Set<Integer> set = new HashSet<>();
		for (int i : candyType)
		{
			set.add(i);
		}
		int diff = set.size();

		return diff < maxToEat ? diff : maxToEat;
	}
}
