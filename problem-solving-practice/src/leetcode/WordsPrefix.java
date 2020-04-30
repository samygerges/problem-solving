package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsPrefix
{
	class TrieNode
	{
		Map<Character, TrieNode> children;
		String content;
		boolean isWord;

		TrieNode()
		{
			children = new HashMap<>();
		}
	}

	private void buildTrie(String[] words, TrieNode root)
	{
		for (String word : words)
		{
			TrieNode current = root;
			for (char c : word.toCharArray())
			{
				current = current.children.computeIfAbsent(c, node -> new TrieNode());
			}
			current.isWord = true;
			current.content = word;
		}
	}

	public boolean find(String word, TrieNode root)
	{
		TrieNode current = root;
		for (char c : word.toCharArray())
		{
			TrieNode node = current.children.get(c);
			if (node == null)
			{
				return false;
			}
			current = node;
		}
		return current.isWord;
	}

	private void findWordsInNode(TrieNode root, List<String> result)
	{
		if (root == null)
		{
			return;
		}
		if (root.isWord)
		{
			result.add(root.content);
		}
		for (TrieNode node : root.children.values())
		{
			findWordsInNode(node, result);
		}
	}

	public List<String> findByPrefix(String prefix, TrieNode root)
	{
		TrieNode current = root;
		for (char c : prefix.toCharArray())
		{
			TrieNode node = current.children.get(c);
			if (node == null)
			{
				return Collections.emptyList();
			}
			current = node;
		}
		// loop over all words in current
		List<String> result = new ArrayList<>();
		findWordsInNode(current, result);
		return result;
	}

	public List<String> findAllConcatenatedWordsInADict(String[] words, String prefix)
	{
		TrieNode root = new TrieNode();
		buildTrie(words, root);
		return findByPrefix(prefix, root);
	}

	public static void main(String[] args)
	{
		WordsPrefix cw = new WordsPrefix();
		System.out.println(cw.findAllConcatenatedWordsInADict(
			new String[] { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" }, "cat"));
	}
}
