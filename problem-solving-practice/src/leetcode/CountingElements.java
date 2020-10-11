package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountingElements
{
	public int countElements(int[] arr)
	{
		Set<Integer> set = new HashSet<>();
		Arrays.stream(arr).forEach(set::add);
		int count = 0;
		for (int i : arr)
		{
			if (set.contains(i + 1))
			{
				count++;
			}
		}
		return count;
	}
}
