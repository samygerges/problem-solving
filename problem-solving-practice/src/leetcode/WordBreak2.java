package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2
{
	public static void main(String[] args)
	{
		WordBreak2 s = new WordBreak2();
		System.out.println(s.wordBreak("catsanddog", Arrays.asList(new String[] { "cat", "cats", "and", "sand", "dog" }.clone())));
	}

	public List<String> wordBreak(String s, List<String> wordDict)
	{
		return wordBreak(s, wordDict, new HashMap<>());
	}

	public List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> map)
	{
		if (map.containsKey(s))
		{
			return map.get(s);
		}
		List<String> res = new ArrayList<>();
		if (s.isEmpty())
		{
			res.add("");
			return res;
		}

		for (String str : wordDict)
		{
			if (s.startsWith(str))
			{
				List<String> result = wordBreak(s.substring(str.length()), wordDict, map);
				for (String substr : result)
				{
					String space = substr.isEmpty() ? "" : " ";
					res.add(str + space + substr);
				}
			}
		}
		map.put(s, res);
		return res;
	}
}
