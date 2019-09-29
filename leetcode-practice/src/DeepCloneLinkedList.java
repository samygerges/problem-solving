// Definition for a Node.
package main.java.com.leetcode;

import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

class DeepCloneLinkedList {

    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node node = new Node();
        node.val = head.val;

        Node newHead = node;
        Node oldHead = head;

        Map<Node,Node> nodeToNode = new HashMap<>();

        nodeToNode.put(head,node);

        while(head.next !=null){
            node.next = new Node();
            node.next.val = head.next.val;
            nodeToNode.put(head.next, node.next);

            head = head.next;
            node = node.next;
        }

        node = newHead;`
        while(oldHead !=null){
            node.random = nodeToNode.get(oldHead.random);
            oldHead = oldHead.next;
            node = node.next;
        }

        return newHead;
    }
}

