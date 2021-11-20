package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null").append(',');

            } else {
                sb.append(node.val).append(',');
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode node = queue.poll();
            if (!nodes[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                node.left = left;
                queue.add(left);
            }
            i++;
            if (!nodes[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                node.right = right;
                queue.add(right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        r1.left = r2;
        r1.right = r3;
        r3.left = r4;
        r3.right = r5;
        //System.out.println(new Codec().serialize(r1));
        TreeNode root = new Codec().deserialize("1,2,3,,,4,5");
        System.out.println(root.val);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;