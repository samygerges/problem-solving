package leetcode;

public class SwapNodes
{
	public ListNode swapNodes(ListNode head, int k)
	{
		int len = 0;
		ListNode runner = head;
		while (runner != null)
		{
			len++;
			runner = runner.next;
		}

		ListNode i = null;
		ListNode j = null;
		int index = 0;
		runner = head;

		while (runner != null)
		{
			index++;
			if (index == k)
			{
				i = runner;
			}
			if (index == len - k + 1)
			{
				j = runner;
			}
			runner = runner.next;
		}

		int val = i.val;
		i.val = j.val;
		j.val = val;

		return head;
	}
}
