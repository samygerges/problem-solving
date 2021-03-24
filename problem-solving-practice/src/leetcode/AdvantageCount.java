package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AdvantageCount
{
	public static void main(String[] args)
	{
		System.out.println(new AdvantageCount().advantageCount(new int[] { 12, 24, 8, 32 }, new int[] { 13, 25, 32, 11 }));
	}

	public int[] advantageCount(int[] A, int[] B)
	{
		TreeSet<Integer> set = new TreeSet<>();
		Map<Integer, Integer> count = new HashMap<>();

		for (int i : A)
		{
			set.add(i);
			count.putIfAbsent(i, 0);
			count.put(i, count.get(i) + 1);
		}
		Arrays.sort(A);

		int[] res = new int[A.length];

		for (int i = 0; i < A.length; i++)
		{
			Integer x = set.higher(B[i]);
			if (x == null)
			{
				for (int j = 0; j < A.length; j++)
				{
					if (set.contains(A[j]))
					{
						x = A[j];
						break;
					}
				}
			}
			res[i] = x;
			if (count.get(x) == 1)
			{
				set.remove(x);
			}
			else
			{
				count.put(x, count.get(x) - 1);
			}
		}

		return res;
	}
}
