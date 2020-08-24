package leetcode;

import java.util.HashMap;
import java.util.Map;

public class StreamChecker {

	TrieNode root;
	StringBuilder sb;

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean isWord;

		TrieNode() {
			children = new HashMap<>();
		}
	}

	public StreamChecker(String[] words) {
		sb = new StringBuilder();
		root = new TrieNode();
		for (String word : words) {
			TrieNode current = root;
			for (int i = word.length() - 1; i >= 0; i--) {
				current = current.children.computeIfAbsent(word.charAt(i), node -> new TrieNode());
			}
			current.isWord = true;
		}
	}

	public boolean query(char letter) {
		TrieNode current = root;
		sb.append(letter);

		for (int i = sb.length() - 1; i >= 0; i--) {
			if (current.children.containsKey(sb.charAt(i))) {
				if (current.children.get(sb.charAt(i)).isWord) {
					return true;
				} else {
					current = current.children.get(sb.charAt(i));
				}
			} else {
				break;
			}
		}

		return false;
	}
}
