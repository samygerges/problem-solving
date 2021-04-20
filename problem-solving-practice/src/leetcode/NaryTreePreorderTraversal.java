package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal
{
	public List<Integer> preorder(Node root) {
		if(root == null) {
			return new ArrayList<>();
		}
		List<Integer> all = new ArrayList<>();
		all.add(root.val);
		for(Node node : root.children) {
			all.addAll(preorder(node));
		}
		return all;
	}

	class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
}

