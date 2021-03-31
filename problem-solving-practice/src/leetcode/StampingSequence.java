package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StampingSequence
{
	public static void main(String[] args)
	{
		//int[] res = new StampingSequence().movesToStamp("abc", "ababc");
		int[] res = new StampingSequence().movesToStamp("abca", "aabcaca");
		for (int i : res)
		{
			System.out.print(i + " ");
		}
	}

	public int[] movesToStamp(String stamp, String target)
	{
		int stampLength = stamp.length();
		List<Integer> result = new ArrayList();
		int lastMatxhedIndex = target.length();
		for (int i = target.length() - stampLength; i >= 0; i--)
		{
			boolean match = isMatched(i, stamp, target, lastMatxhedIndex);
			if (match)
			{
				int lastMatch = i + stampLength - 1;
				result.add(0, i);
				int j = i + 1;
				while (lastMatch < lastMatxhedIndex - 1 && j <= lastMatch)
				{
					boolean isMatched = isMatched(j, stamp, target, lastMatch, lastMatxhedIndex);
					if (isMatched)
					{
						lastMatch = j + stampLength - 1;
						if (lastMatch >= target.length())
						{
							return new int[] {};
						}
						result.add(0, j);
					}
					j++;
				}
				if (lastMatch < lastMatxhedIndex - 1)
				{
					return new int[] {};
				}
				lastMatxhedIndex = i;
			}
		}
		if (lastMatxhedIndex != 0)
		{
			return new int[] {};
		}
		return result.stream().mapToInt(k -> k).toArray();
	}

	private boolean isMatched(int start, String stamp, String target, int lastMatchedIndex)
	{
		int end = Math.min(start + stamp.length() - 1, lastMatchedIndex - 1);
		for (int i = start; i <= end; i++)
		{
			if (target.charAt(i) != stamp.charAt(i - start))
			{
				return false;
			}
		}
		return true;
	}

	private boolean isMatched(int start, String stamp, String target, int ignore, int lastMatchedIndex)
	{
		int end = Math.min(start + stamp.length() - 1, lastMatchedIndex - 1);
		for (int i = ignore + 1; i <= end; i++)
		{
			if (target.charAt(i) != stamp.charAt(i - start))
			{
				return false;
			}
		}
		return true;
	}
}
