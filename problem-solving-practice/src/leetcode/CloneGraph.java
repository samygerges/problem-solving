package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	Map<Node, Node> map = new HashMap<>();

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		if (map.containsKey(node)) {
			return map.get(node);
		}

		Node head = new Node();
		head.val = node.val;
		head.neighbors = new ArrayList<>();
		map.put(node, head);
		for (int i = 0; i < node.neighbors.size(); i++) {
			head.neighbors.add(cloneGraph(node.neighbors.get(i)));
		}
		return head;
	}

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
}
