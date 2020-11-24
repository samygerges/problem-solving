package leetcode;

import java.util.ArrayDeque;

public class BasicCalculator2 {
	public static void main(String[] args) {
		System.out.println(new BasicCalculator2().calculate("12-3*4"));
	}

	public int calculate(String s) {
		int i = 0;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		ArrayDeque<Character> operator = new ArrayDeque<>();
		while (i < s.length()) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
				operator.push(s.charAt(i));
			} else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				int num = s.charAt(i) - 48;
				int j = i + 1;
				while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
					num *= 10;
					num += s.charAt(j) - 48;
					j++;
					i = j - 1;
				}
				if (!operator.isEmpty() && (operator.peek() == '*' || operator.peek() == '/') && stack.size() > 0) {
					int res;
					if (operator.peek() == '*') {
						res = stack.pop() * num;
					} else {
						res = stack.pop() / num;
					}
					stack.push(res);
					operator.pop();
				} else {
					stack.push(num);
				}
			}
			i++;
		}

		while (!operator.isEmpty()) {
			int res;
			if (operator.peekLast() == '+') {
				res = stack.removeLast() + stack.removeLast();
			} else {
				int x = stack.removeLast();
				int y = stack.removeLast();
				res = x - y;
			}
			operator.removeLast();
			stack.addLast(res);
		}

		return stack.pop();
	}
}
