package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MaxSubarraySum
{
	public static void main(String[] args)
	{
		System.out.println(maximumSum(new long[] { 3, 3, 9, 9, 5 }, 7));
	}

	static long maximumSum(long[] a, long m)
	{
		long current = 0;
		TreeSet<Long> set = new TreeSet<>();
		long max = 0;
		for (long aa : a)
		{
			current = (current + (aa % m)) % m;
			max = Math.max(max, current);

			Long higer = set.higher(current);
			if (higer != null)
			{
				max = Math.max(max, (current - higer + m) % m);
			}
			set.add(current);
		}
		return max;
	}

	static long maximumSumTLE(long[] a, long m)
	{
		List<Long> sums = new ArrayList<>();
		for (int i = 1; i <= a.length; i++)
		{
			sum(a, i, 0, 0, 0, sums);
		}
		long max = 0;
		for (long sum : sums)
		{
			max = Math.max(max, sum % m);
		}
		return max;
	}

	private static void sum(long[] a, int length, int index, long sum, int currentLen, List<Long> sums)
	{
		if (currentLen == length)
		{
			sums.add(sum);
			return;
		}

		for (int i = index; i < a.length; i++)
		{
			currentLen++;
			sum += a[i];
			sum(a, length, i, sum, currentLen, sums);
			currentLen--;
			sum -= a[i];
		}
	}
}
