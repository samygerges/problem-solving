package leetcode;

import java.util.ArrayDeque;

public class BSTIterator {
    private ArrayDeque<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new ArrayDeque<>();
        traverse(root);
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        queue.add(root.val);
        traverse(root.right);
    }

    public int next() {
        if(!queue.isEmpty()) {
            return queue.poll();
        }
        return -1;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
