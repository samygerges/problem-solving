package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HasAllCodes
{
	public static void main(String[] args)
	{
		System.out.println(new HasAllCodes().hasAllCodes("0000000001011100", 4));
	}

	public boolean hasAllCodes(String s, int k)
	{
		Set<String> all = new HashSet<>();
		for (int i = 0; i < s.length() - k; i++)
		{
			all.add(s.substring(i, i + k));
		}

		return all.size() == 1 << k;
	}

	public boolean hasAllCodesTLE(String s, int k)
	{
		Set<String> all = new HashSet<>();
		long time = System.currentTimeMillis();
		getAllPremutation(k, new int[] { 0, 1 }, new StringBuilder(), all);
		System.out.println("Premutation took: " + (System.currentTimeMillis() - time));

		time = System.currentTimeMillis();
		for (String str : all)
		{
			if (s.indexOf(str) == -1)
			{
				System.out.println("find took: " + (System.currentTimeMillis() - time));
				return false;
			}
		}
		System.out.println("find took: " + (System.currentTimeMillis() - time));
		return true;
	}

	private void getAllPremutation(int k, int[] arr, StringBuilder str, Set<String> all)
	{
		if (str.length() == k)
		{
			all.add(str.toString());
			return;
		}

		for (int i = 0; i < arr.length; i++)
		{
			str.append(arr[i]);
			getAllPremutation(k, arr, str, all);
			str.deleteCharAt(str.length() - 1);
		}
	}
}
