package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations
{
	public List<String> letterCombinations(String digits)
	{
		if (digits == null || digits.length() == 0)
		{
			return new ArrayList<>();
		}
		char[][] arr = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
		                 { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

		List<String> res = new ArrayList<>();
		helper(digits, arr, 0, new StringBuilder(), res);
		return res;
	}

	private void helper(String digits, char[][] arr, int st, StringBuilder tmp, List<String> res)
	{
		if (tmp.length() == digits.length())
		{
			res.add(tmp.toString());
			return;
		}

		char[] a = arr[digits.charAt(st) - 48];
		for (int i = 0; i < a.length; i++)
		{
			tmp.append(a[i]);
			helper(digits, arr, st + 1, tmp, res);
			tmp.deleteCharAt(tmp.length() - 1);
		}
	}
}
