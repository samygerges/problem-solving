package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OriginalDigits
{
	public static void main(String[] args)
	{
		System.out.println(new OriginalDigits().originalDigits("zeroonetwothreefourfivesixseveneightnine"));
	}

	public String originalDigits(String s)
	{
		int[] nums = new int[] { 0, 6, 4, 2, 8, 5, 1, 3, 7, 9 };
		char[] numbers = new char[] { 'z', 'x', 'u', 'w', 'g', 'f', 'o', 'r', 's', 'i' };
		String[] all = new String[] { "zero", "six", "four", "two", "eight", "five", "one", "three", "seven", "nine" };
		int[] snum = new int[26];
		for (char c : s.toCharArray())
		{
			snum[c - 'a']++;
		}

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < 10; i++)
		{
			if (snum[numbers[i] - 'a'] > 0)
			{
				int count = snum[numbers[i] - 'a'];
				for (int j = 0; j < count; j++)
				{
					res.add(nums[i]);
				}
				for (char c : all[i].toCharArray())
				{
					snum[c - 'a'] -= count;
				}
			}
		}

		Collections.sort(res);
		StringBuilder sb = new StringBuilder();
		for (int i : res)
		{
			sb.append(i);
		}
		return sb.toString();
	}
}
