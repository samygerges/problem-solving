package leetcode;

import java.util.Arrays;

public class PermutationInString
{
	public static void main(String[] args)
	{
		System.out.println(new PermutationInString().checkInclusion("adc", "dcda"));
		System.out.println(new PermutationInString().checkInclusion("ab", "eidboaoo"));
	}

	public boolean checkInclusion(String s1, String s2)
	{
		int[] arr = new int[26];

		boolean start = false;
		int index = -1;
		for (int i = 0; i < s2.length() - s1.length() + 1; i++)
		{
			fillArray(arr, s1);
			boolean all = true;
			for (int j = i; j < i + s1.length(); j++)
			{
				if (arr[s2.charAt(j) - 'a'] > 0)
				{
					arr[s2.charAt(j) - 'a']--;
				}
				else
				{
					all = false;
					break;
				}
			}
			if (all)
			{
				return true;
			}

		}
		return false;
	}

	private void fillArray(int[] arr, String s1)
	{
		Arrays.fill(arr, 0);
		for (char c : s1.toCharArray())
		{
			arr[c - 'a']++;
		}
	}
}
