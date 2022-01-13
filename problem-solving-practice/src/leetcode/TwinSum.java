package leetcode;

import java.util.ArrayDeque;

public class TwinSum {
    public int pairSum(ListNode head) {
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        int n = 0;
        ListNode pointer = head;
        while (pointer != null) {
            n++;
            pointer = pointer.next;
        }
        pointer = head;
        int counter = 0;
        while (pointer != null) {
            if (counter >= n / 2) {
                stack.push(pointer);
            }
            counter++;
            pointer = pointer.next;
        }
        int max = Integer.MIN_VALUE;
        pointer = head;
        while (!stack.isEmpty()) {
            max = Math.max(pointer.val + stack.pop().val, max);
            pointer = pointer.next;
        }
        return max;
    }
}
