package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MissingNumbers
{
	static int[] missingNumbers(int[] arr, int[] brr)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : brr)
		{
			int count = map.getOrDefault(i, 0);
			map.put(i, count + 1);
		}
		for (int i : arr)
		{
			map.put(i, map.get(i) - 1);
		}

		Set<Integer> set = new HashSet<>();
		for (int i : map.keySet())
		{
			if (map.get(i) > 0)
			{
				set.add(i);
			}
		}
		int[] answer = new int[set.size()];
		int index = 0;
		for (int i : set)
		{
			answer[index++] = i;
		}
		Arrays.sort(answer);
		return answer;
	}
}
