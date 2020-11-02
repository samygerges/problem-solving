package leetcode;

public class ConvertBinaryNumberLinkedListInteger {
	public int getDecimalValue(ListNode head) {
		ListNode pointer = head;
		int n = -1;
		while (pointer != null) {
			pointer = pointer.next;
			n++;
		}

		pointer = head;
		int num = 0;
		while (pointer != null) {
			num += pointer.val * Math.pow(2, n);
			n--;
			pointer = pointer.next;
		}
		return num;
	}

	public int getDecimalValue2(ListNode head) {
		ListNode pointer = head;
		int num = 0;
		while (pointer != null) {
			num = (num << 1) | pointer.val;
			pointer = pointer.next;
		}
		return num;
	}
}
