package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Spellchecker
{
	public static void main(String[] args)
	{
		System.out.println(new Spellchecker().spellchecker(new String[] { "KiTe", "kite", "hare", "Hare" }, new String[] { "keti" }));
	}

	public String[] spellchecker(String[] wordlist, String[] queries)
	{
		Set<String> words = new HashSet<>();
		Map<String, String> map = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();

		for (String s : wordlist)
		{
			words.add(s);
			map.putIfAbsent(s.toLowerCase(), s);
			map2.putIfAbsent(markVowels(s), s);
		}

		String[] res = new String[queries.length];
		for (int i = 0; i < queries.length; i++)
		{
			res[i] = "";
			if (words.contains(queries[i]))
			{
				res[i] = queries[i];
			}
			else if (map.containsKey(queries[i].toLowerCase()))
			{
				res[i] = map.get(queries[i].toLowerCase());
			}
			else
			{
				String s = markVowels(queries[i]);
				if (map2.containsKey(s))
				{
					res[i] = map2.get(s);
				}
			}
		}
		return res;
	}

	private String markVowels(String query)
	{
		char[] arr = query.toCharArray();
		for (int i = 0; i < arr.length; i++)
		{
			char c = Character.toLowerCase(arr[i]);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			{
				arr[i] = '*';
			}
			else
			{
				arr[i] = c;
			}
		}
		return new String(arr);
	}
}
