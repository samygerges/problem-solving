package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestWordInDictionary {

    private TrieNode root;

    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word : words) {
            insert(word);
        }

        String answer = "";

        for(String word : words) {
            if(answer.length() <= word.length() &&
                    isCandidate(word)) {
                if((answer.length() == word.length() && answer.compareTo(word) > 0) ||
                        answer.length() < word.length()) {
                    answer = word;
                }

            }
        }
        return answer;
    }

    private boolean isCandidate(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            current = current.children.get(c);
            if(!current.isWord) {
                return false;
            }
        }
        return true;
    }

    private void insert(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, node -> new TrieNode());
        }
        current.isWord = true;
        current.content = word;
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        String content;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
        }
    }
}
