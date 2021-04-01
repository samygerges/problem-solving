package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList
{
	public boolean isPalindrome(ListNode head)
	{
		List<Integer> nodes = new ArrayList<>();
		while (head != null)
		{
			nodes.add(head.val);
			head = head.next;
		}

		for (int i = 0; i < nodes.size() / 2; i++)
		{
			if (nodes.get(i).intValue() != nodes.get(nodes.size() - i - 1).intValue())
			{
				return false;
			}
		}
		return true;
	}
}
