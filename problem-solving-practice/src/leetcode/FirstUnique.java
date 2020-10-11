package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUnique
{
	public static void main(String[] args)
	{
		FirstUnique f = new FirstUnique(new int[] { 7, 7, 7, 7, 7, 7 });
		System.out.println(f.showFirstUnique());
		f.add(7);
		f.add(3);
		f.add(3);
		f.add(7);
		f.add(17);
		System.out.println(f.showFirstUnique());
	}

	class Node
	{
		int val;
		Node next;
		Node prev;

		public Node(int val)
		{
			this.val = val;
		}
	}

	private Set<Integer> set = new HashSet<>();
	private final Map<Integer, Node> map = new HashMap<>();
	private Node head;
	private Node tail;

	public FirstUnique(int[] nums)
	{
		if (nums != null)
		{
			for (int i : nums)
			{
				add(i);
			}
		}
	}

	public int showFirstUnique()
	{
		if (head != null)
		{
			return head.val;
		}
		return -1;
	}

	public void add(int value)
	{
		if (!set.add(value))
		{
			if (map.containsKey(value))
			{
				Node node = map.get(value);
				if (head == node && tail == node)
				{
					head = null;
					tail = null;
				}
				else if (tail == node)
				{
					tail = node.prev;
					tail.next = null;
				}
				else if (head == node)
				{
					head = node.next;
					head.prev = null;
				}
				else
				{
					Node next = node.next;
					Node prev = node.prev;
					node.next.prev = prev;
					node.prev.next = next;
				}
				map.remove(value);
			}
		}
		else
		{
			Node node = new Node(value);
			node.prev = tail;
			if (tail != null)
			{
				tail.next = node;
			}
			tail = node;
			if (head == null)
			{
				head = node;
			}
			map.put(value, node);
		}
	}
}

/**
 * Your FirstUnique object will be instantiated and called as such: FirstUnique obj = new FirstUnique(nums); int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */