package leetcode;

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
		LongestValidParentheses l = new LongestValidParentheses();
		System.out.println(l.longestValidParentheses("()(()"));
		System.out.println(l.longestValidParentheses(")()())"));
	}

	public int longestValidParentheses(String s) {
		int max = 0;
		int[] dp = new int[s.length()];

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public int longestValidParenthesesTLE(String s) {
		int max = 0;
		int[][] dp = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j += 2) {
				String str;
				int currentMax = 0;
				if (j - 2 >= 0 && dp[i][j - 2] != 0) {
					str = s.substring(j - 1, j + 1);
					currentMax = dp[i][j - 2] + 2;
				} else {
					str = s.substring(i, j + 1);
					currentMax = str.length();
				}
				Stack<Character> stack = new Stack<>();
				for (char c : str.toCharArray()) {
					if (c == '(') {
						stack.push(c);
					} else {
						if (stack.isEmpty()) {
							currentMax = -1;
							break;
						} else {
							stack.pop();
						}
					}
				}
				if (currentMax == -1) {
					break;
				}
				if (stack.isEmpty()) {
					dp[i][j] = currentMax;
					max = Math.max(max, currentMax);
				}
			}
		}
		return max;
	}
}
