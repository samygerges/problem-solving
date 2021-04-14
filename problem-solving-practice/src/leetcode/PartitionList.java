package leetcode;

public class PartitionList
{
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		ListNode p = head;
		p.next = new ListNode(4);
		p = p.next;
		p.next = new ListNode(3);
		p = p.next;
		p.next = new ListNode(2);
		p = p.next;
		p.next = new ListNode(5);
		p = p.next;
		p.next = new ListNode(2);

		new PartitionList().partition(head, 3);
	}

	public ListNode partition(ListNode head, int x)
	{
		ListNode h1 = null;
		ListNode h2 = null;
		ListNode p1 = null;
		ListNode p2 = null;

		while (head != null)
		{
			if (head.val < x)
			{
				if (h1 == null)
				{
					h1 = new ListNode(head.val);
					p1 = h1;
				}
				else
				{
					h1.next = new ListNode(head.val);
					h1 = h1.next;
				}
			}
			else
			{
				if (h2 == null)
				{
					h2 = new ListNode(head.val);
					p2 = h2;
				}
				else
				{
					h2.next = new ListNode(head.val);
					h2 = h2.next;
				}
			}
			head = head.next;
		}

		if (h1 != null)
		{
			h1.next = p2;
		}
		else
		{
			p1 = p2;
		}
		return p1;
	}
}
