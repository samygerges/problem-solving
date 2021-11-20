package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allLeft = new ArrayList<>();
        List<String> allRight = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        path.append(root.val);
        if (root.left == null && root.right == null) {
            allLeft.add(path.toString());
        }
        if (root.left != null) binaryTreePaths(root.left, new StringBuilder(path), allLeft);
        if (root.right != null) binaryTreePaths(root.right, new StringBuilder(path), allRight);
        allLeft.addAll(allRight);
        return allLeft;
    }

    private void binaryTreePaths(TreeNode root, StringBuilder path, List<String> all) {
        path.append("->").append(root.val);
        if (root.left == null && root.right == null) {
            all.add(path.toString());
            return;
        }
        if (root.left != null) binaryTreePaths(root.left, new StringBuilder(path), all);
        if (root.right != null) binaryTreePaths(root.right, new StringBuilder(path), all);
    }
}
