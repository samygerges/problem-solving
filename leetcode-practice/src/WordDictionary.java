
import java.util.HashMap;
import java.util.Map;

public class WordDictionary
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
	public WordDictionary()
	{
		root = new TrieNode();
	}

	/**
	 * Adds a word into the data structure.
	 */
	public void addWord(String word)
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
	 * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
	 */
	public boolean search(String word)
	{
		return search(word, root, 0);
	}

	private boolean search(String word, TrieNode root, int index)
	{
		if (index == word.length())
		{
			return root.isWord;
		}

		TrieNode current = root;
		for (int i = index; i < word.length(); i++)
		{
			if (word.charAt(i) == '.')
			{
				for (TrieNode node : current.children.values())
				{
					if (search(word, node, i + 1))
					{
						return true;
					}
				}
				return false;
			}
			else
			{
				current = current.children.get(word.charAt(i));
				if (current == null)
				{
					return false;
				}
			}
		}
		return current.isWord;
	}
}
/**
 * Your WordDictionary object will be instantiated and called as such: WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2 =
 * obj.search(word);
 */