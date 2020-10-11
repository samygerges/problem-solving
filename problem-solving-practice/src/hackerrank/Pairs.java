package hackerrank;

import java.util.HashSet;
import java.util.Set;

public class Pairs
{
	static int pairs(int k, int[] arr)
	{
		Set<Integer> set = new HashSet<>();
		for (int i : arr)
		{
			set.add(i);
		}
		int count = 0;
		for (int i : arr)
		{
			if (i != (i - k) && set.contains(i - k))
			{
				count++;
			}
		}
		return count;
	}
}
