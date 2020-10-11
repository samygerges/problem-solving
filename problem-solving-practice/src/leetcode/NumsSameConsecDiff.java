package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumsSameConsecDiff
{
	public static void main(String[] args)
	{
		System.out.println(new NumsSameConsecDiff().numsSameConsecDiff(3, 7));
	}

	public int[] numsSameConsecDiff(int N, int K)
	{
		List<Integer> all = new ArrayList<>();
		int start = N == 1 ? 0 : 1;

		for (int i = start; i <= 9; i++)
		{
			generateNum(K, N, 1, i, all);
		}
		return all.stream().mapToInt(Integer::intValue).toArray();
	}

	private void generateNum(int k, int len, int currentLen, int num, List<Integer> all)
	{
		if (len == currentLen)
		{
			all.add(num);
			return;
		}
		if (len < currentLen)
		{
			return;
		}
		int last = num % 10;
		int next = last + k < 10 ? last + k : -1;
		int prev = last - k >= 0 ? last - k : -1;
		if (prev != -1)
		{
			generateNum(k, len, currentLen + 1, num * 10 + prev, all);
		}
		if (next != -1 && prev != next)
		{
			generateNum(k, len, currentLen + 1, num * 10 + next, all);
		}
	}
}
