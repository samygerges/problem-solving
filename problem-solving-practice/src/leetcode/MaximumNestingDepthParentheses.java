package leetcode;

import java.util.ArrayDeque;
import java.util.Stack;

public class MaximumNestingDepthParentheses
{
	public int maxDepth(String s) {
		int max = 0;
		ArrayDeque<Character> stack = new ArrayDeque<>();

		for(char c : s.toCharArray()) {
			if(c == '(') {
				stack. push(c);
			}
			else if (c == ')') {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}

			max = Math.max(max, stack.size());
		}

		return max;
	}
}
