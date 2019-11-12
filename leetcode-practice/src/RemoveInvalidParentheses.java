import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParentheses {

	public List<String> removeInvalidParentheses(String s) {
		int countOpen = 0;
		int countClose = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				countOpen++;
			if (s.charAt(i) == ')')
				countClose++;
		}

		Set<String> res = new HashSet<>();

		char toRemove = countOpen > countClose ? '(' : ')';
		int count = Math.abs(countOpen - countClose);
		if (count == 0) {
			if (valid(s)) {
				res.add(s);
				return new ArrayList<String>(res);
			}
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(' || s.charAt(i) == ')') {
					s = s.substring(0, i) + s.substring(i + 1, s.length());
					i--;
				}
			}
			res.add(s);
			return new ArrayList<String>(res);
		}

		if (count == 1) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == toRemove) {
					String str = s.substring(0, i) + s.substring(i + 1, s.length());
					if (valid(str))
						res.add(str);
				}
			}
		} else if (count > 1) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == toRemove) {
					String str = s.substring(0, i) + s.substring(i + 1, s.length());
					res.addAll(removeInvalidParentheses(str));
				}
			}
		}

		if(res.isEmpty()) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(' || s.charAt(i) == ')') {
					s = s.substring(0, i) + s.substring(i + 1, s.length());
					i--;
				}
			}
			res.add(s);
			return new ArrayList<String>(res);
		}
		return new ArrayList<String>(res);
	}

	private boolean valid(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				if (stack.isEmpty())
					return false;
				stack.pop();
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		RemoveInvalidParentheses a = new RemoveInvalidParentheses();
		System.out.println(a.removeInvalidParentheses("))("));
	}
}
