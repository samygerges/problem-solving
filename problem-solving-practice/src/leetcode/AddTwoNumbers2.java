package leetcode;

import java.util.ArrayDeque;

public class AddTwoNumbers2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ArrayDeque<Integer> s1 = new ArrayDeque<>();
		ArrayDeque<Integer> s2 = new ArrayDeque<>();

		while (l1 != null) {
			s1.addFirst(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			s2.addFirst(l2.val);
			l2 = l2.next;
		}

		ListNode head = new ListNode(-1);
		int carry = 0;
		while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
			int x = s1.isEmpty() ? 0 : s1.removeFirst();
			int y = s2.isEmpty() ? 0 : s2.removeFirst();
			int sum = x + y + carry;

			ListNode node = new ListNode(sum % 10);
			if (head.val != -1) {
				node.next = head;
			}
			carry = sum / 10;
			head = node;
		}
		return head;
	}
}
