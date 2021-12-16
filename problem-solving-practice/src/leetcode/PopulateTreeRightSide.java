package leetcode;

import java.util.ArrayDeque;

public class PopulateTreeRightSide {
    public Node connect(PopulateTreeRightSide.Node root) {
        if(root == null) {
            return null;
        }
        ArrayDeque<PopulateTreeRightSide.Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                PopulateTreeRightSide.Node node = queue.poll();
                if(i + 1 < size) {
                    node.next = queue.peek();
                }
                if(node.left != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}


