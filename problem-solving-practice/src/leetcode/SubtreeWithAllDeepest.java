package leetcode;

import java.util.*;

public class SubtreeWithAllDeepest {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(root);
        parent.put(root, null);
        deepestNode(root, 0, map, parent);

        int maxLevel = 0;
        for(int key : map.keySet()) {
            maxLevel = Math.max(maxLevel, key);
        }

        Set<TreeNode> parents = new HashSet<>();
        for (TreeNode node : map.get(maxLevel)) {
            parents.add(parent.get(node));
        }
        while (parents.size() > 1) {
            Set<TreeNode> tmp = new HashSet<>();
            for (TreeNode parentNode : parents) {
                tmp.add(parent.get(parentNode));
            }
            parents = new HashSet<>(tmp);
        }
        return parents.iterator().next();
    }

    private void deepestNode(TreeNode root, int level, Map<Integer, List<TreeNode>> map, Map<TreeNode, TreeNode> parent) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.putIfAbsent(level + 1, new ArrayList<>());
            map.get(level + 1).add(root.left);
            parent.put(root.left, root);
            deepestNode(root.left, level + 1, map, parent);
        }
        if (root.right != null) {
            map.putIfAbsent(level + 1, new ArrayList<>());
            map.get(level + 1).add(root.right);
            parent.put(root.right, root);
            deepestNode(root.right, level + 1, map, parent);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.left = n5;
        n2.right = n4;
        System.out.println(new SubtreeWithAllDeepest().subtreeWithAllDeepest(n1));
    }
}
