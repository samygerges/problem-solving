package leetcode;

public class RotateList
{
	class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}

	public ListNode rotateRight(ListNode head, int k)
	{
		if (head == null)
		{
			return null;
		}
		if (k == 0)
		{
			return head;
		}
		int n = 0;
		ListNode runner = head;
		while (runner != null)
		{
			n++;
			runner = runner.next;
		}

		int rotate = k % n;
		if (rotate == 0)
		{
			return head;
		}
		ListNode fastRunner = head;
		for (int i = 0; i < n - rotate - 1; i++)
		{
			fastRunner = fastRunner.next;
		}
		ListNode newHead = fastRunner.next;
		fastRunner.next = null;
		ListNode tail = newHead;
		while (tail.next != null)
		{
			tail = tail.next;
		}
		tail.next = head;
		return newHead;
	}
}

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int
 * val, ListNode next) { this.val = val; this.next = next; } }
 */