
import java.util.HashMap;
import java.util.Map;

public class Trie
{
	TrieNode root;

	class TrieNode
	{
		Map<Character, TrieNode> children;
		boolean isWord;
		String content;

		TrieNode()
		{
			children = new HashMap<>();
		}
	}

	/**
	 * Initialize your data structure here.
	 */
	public Trie()
	{
		root = new TrieNode();
	}

	/**
	 * Inserts a word into the trie.
	 */
	public void insert(String word)
	{
		TrieNode current = root;
		for (char c : word.toCharArray())
		{
			current = current.children.computeIfAbsent(c, node -> new TrieNode());
		}
		current.isWord = true;
		current.content = word;
	}

	/**
	 * Returns if the word is in the trie.
	 */
	public boolean search(String word)
	{
		TrieNode current = root;
		for (char c : word.toCharArray())
		{
			current = current.children.get(c);
			if (current == null)
			{
				return false;
			}
		}
		return current.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix)
	{
		TrieNode current = root;
		for (char c : prefix.toCharArray())
		{
			current = current.children.get(c);
			if (current == null)
			{
				return false;
			}
		}
		return true;
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean
 * param_3 = obj.startsWith(prefix);
 */
