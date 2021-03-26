package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets
{
	public static void main(String[] args)
	{
		System.out.println(
			new WordSubsets().wordSubsets(new String[] { "amazon", "apple", "facebook", "google", "leetcode" }, new String[] { "e", "o" }));
	}

	public List<String> wordSubsets(String[] A, String[] B)
	{
		int[][] words = new int[A.length][26];
		int[] barr = new int[26];

		int index = 0;
		for (String a : A)
		{
			for (int i = 0; i < a.length(); i++)
			{
				words[index][a.charAt(i) - 97]++;
			}
			index++;
		}

		for (String b : B)
		{
			int[] arr = new int[26];
			for (int i = 0; i < b.length(); i++)
			{
				arr[b.charAt(i) - 97]++;
			}

			for (int i = 0; i < 26; i++)
			{
				barr[i] = Math.max(barr[i], arr[i]);
			}
		}

		List<String> res = new ArrayList<>();

		for (int i = 0; i < A.length; i++)
		{
			boolean can = true;
			for (int j = 0; j < 26; j++)
			{
				if (barr[j] > words[i][j])
				{
					can = false;
					break;
				}
			}
			if (can)
			{
				res.add(A[i]);
			}
		}

		return res;
	}
}
