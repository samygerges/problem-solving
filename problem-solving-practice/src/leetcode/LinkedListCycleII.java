package leetcode;

public class LinkedListCycleII
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

	public ListNode detectCycle(ListNode head)
	{
		if (head == null)
		{
			return null;
		}
		ListNode runner = head;
		ListNode fastRunner = head;
		boolean isCyclic = false;

		while (runner != null && runner.next != null && fastRunner != null && fastRunner.next != null && fastRunner.next.next != null)
		{
			runner = runner.next;
			fastRunner = fastRunner.next.next;
			if (runner == fastRunner)
			{
				isCyclic = true;
				break;
			}
		}

		if (!isCyclic)
		{
			return null;
		}

		fastRunner = head;

		while (fastRunner != runner)
		{
			fastRunner = fastRunner.next;
			runner = runner.next;
		}

		return runner;
	}
}
