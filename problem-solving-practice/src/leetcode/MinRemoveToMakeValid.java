package leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
