package leetcode;

public class MaximumSumBST {
    class Node {
        int min;
        int max;
        int sum;

        Node(int min, int max, int sum) {
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    int sum = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return sum;
    }

    private Node traverse(TreeNode root) {
        if (root == null) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Node left = traverse(root.left);
        Node right = traverse(root.right);

        if (root.val > left.max && root.val < right.min) {
            sum = Math.max(sum, root.val + left.sum + right.sum);
            return new Node(Math.min(root.val, left.min), Math.max(root.val, right.max), root.val + right.sum + left.sum);
        }

        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum, right.sum));
    }
}
