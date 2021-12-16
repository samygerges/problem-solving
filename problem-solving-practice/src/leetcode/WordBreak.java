package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0)
			return false;

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}

	public boolean wordBreakTrieTLE(String s, List<String> wordDict) {
		if (s == null || s.length() == 0)
			return false;
		TrieNode root = new TrieNode();
		for(String word : wordDict) {
			insert(word, root);
		}
		return search(s, root, root);
	}

	private void insert(String word, TrieNode root) {
		TrieNode current = root;
		for(char c : word.toCharArray()) {
			current = current.children.computeIfAbsent(c, node -> new TrieNode());
		}
		current.isWord = true;
		current.content = word;
	}

	private boolean search(String word, TrieNode root, TrieNode currentNode) {
		TrieNode current = root == currentNode ? root : currentNode;
		for(int i = 0; i < word.length(); i++) {
			current = current.children.get(word.charAt(i));
			if(current == null) {
				return false;
			}
			if(current.isWord && i + 1 < word.length()) {
				return search(word.substring(i + 1), root, root) || search(word.substring(i + 1), root, current);
			}
		}
		return current.isWord;
	}

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean isWord;
		String content;

		TrieNode()
		{
			children = new HashMap<>();
		}
	}
}