package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountVowelStrings
{
	public static void main(String[] args)
	{
		System.out.println(new CountVowelStrings().countVowelStrings(1));
	}

	private char[] arr = new char[] { 'a', 'e', 'i', 'o', 'u' };

	public int countVowelStrings(int n)
	{
		Map<Character, Integer> map = new HashMap<>();
		map.put('a', 0);
		map.put('e', 1);
		map.put('i', 2);
		map.put('o', 3);
		map.put('u', 4);
		Set<String> all = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		countVowelStrings(n, sb, all, map);
		return all.size();
	}

	private void countVowelStrings(int n, StringBuilder s, Set<String> all, Map<Character, Integer> map)
	{
		if (n == 0)
		{
			all.add(s.toString());
			return;
		}
		int index = s.length() == 0 ? 0 : map.get(s.charAt(s.length() - 1));
		for (int i = index; i < 5; i++)
		{
			s.append(arr[i]);
			countVowelStrings(n - 1, s, all, map);
			s.deleteCharAt(s.length() - 1);
		}
	}
}
