package leetcode;

public class FlattenDoubleLinkedList {
	public Node flatten(Node head) {
		Node current = head;
		while (current != null) {
			if (current.child != null) {
				flatten(current, current.next);
			}
			current = current.next;
		}
		return head;
	}

	private void flatten(Node node, Node next) {
		Node current = node;
		current.next = current.child;
		current.child.prev = current;
		current.child = null;
		while (current.next != null) {
			if (current.child != null) {
				flatten(current, current.next);
			}
			current = current.next;
		}
		current.next = next;
		if (next != null) {
			next.prev = current;
		}
	}

	// Definition for a Node.
	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
	}
}
