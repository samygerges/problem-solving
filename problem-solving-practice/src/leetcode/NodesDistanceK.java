package leetcode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NodesDistanceK {
    // Not working solution
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> answer = new ArrayList<>();
        List<int[]> allNodes = new ArrayList<>();
        int[] node = new int[]{root.val, 0, 0};
        Boolean isTargetLeft = null;
        int distanceToTarget = 0;
        ArrayDeque<Pair<TreeNode, int[]>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(root, node));
        while (!queue.isEmpty()) {
            Pair<TreeNode, int[]> curr = queue.poll();
            allNodes.add(curr.getValue());
            TreeNode treeNode = curr.getKey();
            if (treeNode.val == target.val && root.val != treeNode.val) {
                isTargetLeft = curr.getValue()[1] < 0;
                distanceToTarget = curr.getValue()[2];
            }
            if (treeNode.left != null) {
                int[] arr = new int[]{treeNode.left.val, curr.getValue()[1] == 0 ? -1 : curr.getValue()[1], curr.getValue()[2] + 1};
                queue.add(new Pair<>(treeNode.left, arr));
            }
            if (curr.getKey().right != null) {
                int[] arr = new int[]{treeNode.right.val, curr.getValue()[1] == 0 ? 1 : curr.getValue()[1], curr.getValue()[2] + 1};
                queue.add(new Pair<>(treeNode.right, arr));
            }
        }

        for (int[] arr : allNodes) {

            if (isTargetLeft == null && arr[2] == k) {
                answer.add(arr[0]);
            } else {
                boolean sameSide = isTargetLeft != null && ((arr[1] < 0 && isTargetLeft) || (arr[1] > 0 && !isTargetLeft));
                boolean sub = distanceToTarget > arr[2];

                if (sameSide && sub && distanceToTarget - arr[2] == k) {
                    answer.add(arr[0]);
                } else if (sameSide && !sub && arr[2] - distanceToTarget == k) {
                    answer.add(arr[0]);
                } else if (!sameSide && distanceToTarget + arr[2] == k) {
                    answer.add(arr[0]);
                } else if (sameSide && distanceToTarget == k && arr[2] == k && target.val != arr[0]) {
                    answer.add(arr[0]);
                }
            }
        }

        return answer;
    }
}
