package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public void reorderList(ListNode head) {
		List<ListNode> nodes = new ArrayList<>();
		ListNode current = head;
		while (current != null) {
			nodes.add(current);
			current = current.next;
		}

		int left = 0;
		int right = nodes.size() - 1;
		current = null;
		while (left < right) {
			ListNode prev = current;
			current = nodes.get(left);
			if (prev != null)
				prev.next = current;
			current.next = nodes.get(right);
			current.next.next = null;
			current = current.next;
			left++;
			right--;
		}
		if (nodes.size() % 2 != 0) {
			if (current != null) {
				current.next = nodes.get((nodes.size() / 2));
				current.next.next = null;
			} else {
				current = nodes.get((nodes.size() / 2));
			}
		}
	}
}
