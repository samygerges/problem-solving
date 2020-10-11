package leetcode;

import java.util.Stack;

public class RemoveDuplicateLetters {

	public String removeDuplicateLetters(String s) {
		int[] count = new int[26];
		boolean[] visited = new boolean[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			count[c - 'a']--;
			if (visited[c - 'a']) {
				continue;
			}

			while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
				visited[stack.pop() - 'a'] = false;
			}

			visited[c - 'a'] = true;
			stack.push(c);
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.reverse().toString();
	}
}
