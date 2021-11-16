package leetcode;

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        generateAll(n, n * 2, "", set, 0, 0);
        List<String> res = new ArrayList<>();
        for (String s : set) {
            if (isValid(s)) {
                res.add(s);
            }
        }
        return res;
    }

    private void generateAll(int len, int n, String sb, Set<String> all, int left, int right) {
        if (n == 0) {
            if (sb.length() == 2 * len && left == right) {
                all.add(sb);
            }
            return;
        }
        if (left > len && left > right) {
            return;
        }
        if (right > len && left < right) {
            return;
        }
        generateAll(len, n - 1, sb + "(", all, left + 1, right);
        generateAll(len, n - 1, sb + ")", all, left, right + 1);
    }

    private boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
