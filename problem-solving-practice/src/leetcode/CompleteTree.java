package leetcode;

import java.util.ArrayDeque;

public class CompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        boolean hasNoMoreNodes = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null) {
                hasNoMoreNodes = true;
            } else if (hasNoMoreNodes) {
                return false;
            } else {
                queue.add(node.left);
            }
            if (node.right == null) {
                hasNoMoreNodes = true;
            } else if (hasNoMoreNodes) {
                return false;
            } else {
                queue.add(node.right);
            }
        }

        return true;
    }
}
