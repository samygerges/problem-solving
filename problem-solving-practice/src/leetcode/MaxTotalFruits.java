package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaxTotalFruits {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        TreeMap<Integer, Integer> leftMap = new TreeMap<>();
        TreeMap<Integer, Integer> rightMap = new TreeMap<>();

        int n = fruits.length;
        int midIndex = -1;
        for(int i = 0; i < n; i++) {
            if(fruits[i][0] <= startPos) {
                midIndex = i;
            }
        }

        int temp = 0;
        for(int i = midIndex + 1; i < n; i++) {
            int distance = fruits[i][0] - startPos;
            if(startPos > fruits[i][0] || distance > k) break;
            temp += fruits[i][1];
            rightMap.put(distance, temp);
        }

        temp = 0;
        for(int i = midIndex; i >= 0; i--) {
            int distance = startPos - fruits[i][0];
            if(startPos < fruits[i][0] || distance> k) break;
            temp += fruits[i][1];
            leftMap.put(distance, temp);
        }

        return Math.max(getMaxHarvested(leftMap, rightMap, k), getMaxHarvested(rightMap, leftMap, k));
    }

    private int getMaxHarvested(TreeMap<Integer, Integer> first, TreeMap<Integer, Integer> second, int k) {
        int result = 0;
        for (Map.Entry<Integer, Integer> e : first.entrySet()) {
            int remaining = k - (e.getKey() * 2);
            Integer next = second.floorKey(remaining);
            int currentResult = e.getValue();
            if (next != null) {
                currentResult += second.get(next);
            }
            result = Math.max(result, currentResult);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxTotalFruits().maxTotalFruits(new int[][]{{1, 9}, {2, 10}, {3, 1}, {5, 6}, {6, 3}, {8, 2}, {9, 2}, {11, 4}, {18, 10}, {22, 8}, {25, 2}, {26, 2}, {30, 4}, {31, 5}, {33, 9}, {34, 1}, {39, 10}}, 19, 9));
    }

    public int maxTotalFruitsTLE(int[][] fruits, int startPos, int k) {
        List<Integer> rightPos = new ArrayList<>();
        List<Integer> rightSum = new ArrayList<>();
        List<Integer> leftPos = new ArrayList<>();
        List<Integer> leftSum = new ArrayList<>();

        rightPos.add(0);
        rightSum.add(0);
        leftPos.add(0);
        leftSum.add(0);

        int startIndexRight = -1;
        int l = 0;
        int r = fruits.length - 1;
        boolean hasOverlap = false;

        while (l <= r) {
            startIndexRight = l + (r - l) / 2;
            if (fruits[startIndexRight][0] == startPos) {
                hasOverlap = true;
                break;
            } else if (fruits[startIndexRight][0] > startPos) {
                r = startIndexRight - 1;
            } else {
                l = startIndexRight + 1;
            }
        }

        for (int i = startIndexRight; i < fruits.length; i++) {
            int steps = fruits[i][0] - startPos;
            if (steps <= k && steps >= 0) {
                rightPos.add(steps);
                rightSum.add(rightSum.get(rightSum.size() - 1) + fruits[i][1]);
            }
        }

        for (int i = hasOverlap ? startIndexRight - 1 : startIndexRight; i > -1; i--) {
            int steps = startPos - fruits[i][0];
            if (steps <= k && steps >= 0) {
                leftPos.add(steps);
                leftSum.add(leftSum.get(leftSum.size() - 1) + fruits[i][1]);
            }
        }
        int maxSum = Math.max(leftSum.get(leftSum.size() - 1), rightSum.get(rightSum.size() - 1));
        for (int i = rightSum.size() - 1; i > 0; i--) {
            for (int j = 1; j < leftSum.size(); j++) {
                if (rightPos.get(i) + leftPos.get(j) + Math.min(rightPos.get(i), leftPos.get(j)) <= k) {
                    maxSum = Math.max(maxSum, rightSum.get(i) + leftSum.get(j));
                } else {
                    break;
                }
            }
        }
        for (int i = leftSum.size() - 1; i > 0; i--) {
            for (int j = 1; j < rightSum.size(); j++) {
                if (leftPos.get(i) + rightPos.get(j) + Math.min(leftPos.get(i), rightPos.get(j)) <= k) {
                    maxSum = Math.max(maxSum, rightSum.get(j) + leftSum.get(i));
                } else {
                    break;
                }
            }
        }
        return maxSum;
    }
}
