package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumLengthEncoding
{
	public static void main(String[] args)
	{
		System.out.println(new MinimumLengthEncoding().minimumLengthEncoding(new String[] { "time", "me", "bell" }));
	}

	TrieNode root = new TrieNode();

	class TrieNode
	{
		Map<Character, TrieNode> children;

		TrieNode()
		{
			children = new HashMap<>();
		}
	}

	public void insert(String word)
	{
		TrieNode current = root;
		char[] arr = word.toCharArray();
		for (int i = arr.length - 1; i > -1; i--)
		{
			current = current.children.computeIfAbsent(arr[i], node -> new TrieNode());
		}
	}

	public boolean search(String word)
	{
		TrieNode current = root;
		char[] arr = word.toCharArray();
		for (int i = arr.length - 1; i > -1; i--)
		{
			current = current.children.get(arr[i]);
			if (current == null)
			{
				return false;
			}
		}
		return true;
	}

	public int minimumLengthEncoding(String[] words)
	{
		if (words == null || words.length == 0)
		{
			return 0;
		}

		Arrays.sort(words, (a, b) -> {
			return Integer.compare(b.length(), a.length());
		});

		int min = 0;

		for (int i = 0; i < words.length; i++)
		{
			if (!search(words[i]))
			{
				insert(words[i]);
				min += words[i].length() + 1;
			}
		}

		return min;
	}
}
