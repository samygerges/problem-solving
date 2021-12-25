package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SubsequenceLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        Arrays.sort(res, Comparator.comparing(a -> a[1]));
        return Arrays.stream(res).map(pair -> pair[0]).mapToInt(Integer::intValue).toArray();
    }
}
