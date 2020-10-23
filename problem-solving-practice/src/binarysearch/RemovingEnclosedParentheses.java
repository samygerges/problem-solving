package binarysearch;

import java.util.ArrayDeque;

public class RemovingEnclosedParentheses {
	public static void main(String[] args) {
		System.out.println(new RemovingEnclosedParentheses().solve("(b())"));
	}

	public String solve(String s) {
		int count = 0;

		ArrayDeque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			if (stack.size() == s.length() - i) {
				boolean check = true;
				for (int j = i; j < s.length(); j++) {
					if (s.charAt(j) != ')') {
						check = false;
						break;
					}
				}
				if (check) {
					count = stack.size();
					break;
				}
			}
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else if (s.charAt(i) == ')') {
				stack.removeFirst();
			}
			if (stack.isEmpty()) {
				break;
			}
		}

		String ans = s;
		if (count > 0) {
			ans = s.substring(count);
			ans = ans.substring(0, ans.length() - count);
		}
		return ans;
	}
}
