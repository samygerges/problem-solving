package leetcode;
public class ValidParenthesisString {

	public static void main(String[] args) {
		System.out.println(checkValidString("(*))"));
		System.out.println(checkValidString("((()))()(())(*()()())**(())()()()()((*()*))((*()*)"));
		System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
	}

	public static boolean checkValidString(String s) {
		int balance = 0;
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '*')
				balance++;
			else {
				balance--;
				if (balance == -1)
					return false;
			}
		}
		balance = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ')' || s.charAt(i) == '*')
				balance++;
			else {
				balance--;
				if (balance == -1)
					return false;
			}
		}

		return true;
	}
}
