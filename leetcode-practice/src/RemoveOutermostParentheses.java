import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveOutermostParentheses {

	public String removeOuterParentheses(String S) {
		if (S == null || S.length() == 0)
			return "";
		Stack<Character> stack = new Stack<>();
		List<String> list = new ArrayList<>();
		int open = 0;
		int close = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				stack.push('(');
				open++;
			} else {
				if (close + 1 == open) {
					String res = "";
					while (stack.size() > 1) {
						res = stack.pop() + res;
					}
					list.add(res);
					stack.pop();
					open = 0;
					close = 0;
				} else {
					stack.push(')');
					close++;
				}
			}
		}
		String res = "";
		for (String r : list)
			res += r;
		return res;
	}

	public static void main(String[] args) {
		RemoveOutermostParentheses a = new RemoveOutermostParentheses();
		System.out.println(a.removeOuterParentheses("(()())(())"));
	}

}
