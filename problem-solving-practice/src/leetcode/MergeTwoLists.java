package leetcode;

public class MergeTwoLists
{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode current = null;
		while(l1!=null && l2!=null)
		{
			if(l1.val <= l2.val) {
				if(current == null) {
					current = l1;
					head = current;
				} else {
					current.next = l1;
					current = current.next;
				}
				l1 = l1.next;
			} else {
				if(current == null) {
					current = l2;
					head = current;
				} else {
					current.next = l2;
					current = current.next;
				}
				l2 = l2.next;
			}
		}

		while(l1 != null) {
			if(current == null) {
				current = l1;
				head = current;
			}
			else {
				current.next = l1;
				current = current.next;
			}
			l1 = l1.next;
		}

		while(l2 != null) {
			if(current == null) {
				current = l2;
				head = current;
			}
			else {
				current.next = l2;
				current = current.next;
			}
			l2 = l2.next;
		}

		return head;
	}
}
