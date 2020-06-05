package leetcode;

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

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head != null) {
			ListNode pointer = head.next;
			ListNode prev = head;
			while (pointer != null && prev != null) {
				while (pointer != null && pointer.val == val) {
					pointer = pointer.next;
				}
				if (pointer != null) {
					prev.next = pointer;
					prev = prev.next;
					pointer = pointer.next;
				} else {
					prev.next = null;
				}
			}
		}

		return head;
	}
}
