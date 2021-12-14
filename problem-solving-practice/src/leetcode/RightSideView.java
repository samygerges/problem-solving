package leetcode;

import java.util.*;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        traverse(root, map, 0);
        for (int i : map.keySet()) {
            answer.add(map.get(i).get(map.get(i).size() - 1));
        }
        return answer;
    }

    private void traverse(TreeNode root, Map<Integer, List<Integer>> map, int level) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.val);
        traverse(root.left, map, level + 1);
        traverse(root.right, map, level + 1);
    }
}
