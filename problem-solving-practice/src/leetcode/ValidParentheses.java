package leetcode;
import java.util.Stack;

class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;
				char open = stack.pop();
				if ((open == '[' && c != ']') || (open == '(' && c != ')') || (open == '{' && c != '}'))
					return false;
			}
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}
}