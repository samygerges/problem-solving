package leetcode;

import javafx.util.Pair;

import java.util.ArrayDeque;

public class RemoveKDuplicates {
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            int count = 1;
            if (!stack.isEmpty() && stack.peek().getKey() == c) {
                count += stack.peek().getValue();
            }
            if (count == k) {
                for (int i = 0; i < k - 1; i++) {
                    stack.pop();
                }
            } else {
                stack.push(new Pair<>(c, count));
            }
        }
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop().getKey());
        }
        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKDuplicates().removeDuplicates("deeedbbcccbdaa", 3));
    }
}
