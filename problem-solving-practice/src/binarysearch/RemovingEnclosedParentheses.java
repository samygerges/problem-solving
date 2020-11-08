package binarysearch;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class RemovingEnclosedParentheses {
	public static void main(String[] args) {
		System.out.println(new RemovingEnclosedParentheses().solve("(b())"));
	}

	public String solve(String s) {
		Map<Integer, Integer> map = new HashMap<>();
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else if (s.charAt(i) == ')') {
				int index = stack.pop();
				map.put(index, i);
			}
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' && map.get(i) == s.length() - i - 1) {
				count++;
			} else {
				break;
			}
		}
		return s.substring(count, s.length() - count);
	}
}
