package leetcode;

public class InsertionSortList
{
	public ListNode insertionSortList(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode pointer = head;
		int n = -1;
		while(pointer != null) {
			n++;
			pointer = pointer.next;
		}

		for(int i = 0; i < n; i++) {
			sort(head);
		}

		return head;
	}

	private void sort(ListNode head) {
		ListNode p1 = head;
		ListNode p2 = head.next;

		while(p1 != null && p2 != null) {
			if(p1.val > p2.val) {
				int tmp = p1.val;
				p1.val = p2.val;
				p2.val = tmp;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
	}
}
