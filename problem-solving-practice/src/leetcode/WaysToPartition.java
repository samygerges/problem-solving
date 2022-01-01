package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class WaysToPartition {
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        int[] sumLeft = new int[n];
        int[] sumRight = new int[n];
        Map<Integer, TreeSet<Integer>> mapLeft = new HashMap<>();
        Map<Integer, TreeSet<Integer>> mapRight = new HashMap<>();

        sumLeft[0] = nums[0];
        sumRight[n - 1] = nums[n - 1];
        mapLeft.put(k - nums[0], new TreeSet<>());
        mapLeft.get(k - nums[0]).add(0);
        mapRight.put(k - nums[n - 1], new TreeSet<>());
        mapRight.get(k - nums[n - 1]).add(n - 1);

        for (int i = 1; i < n; i++) {
            sumLeft[i] = sumLeft[i - 1] + nums[i];
            mapLeft.putIfAbsent(k - nums[i], new TreeSet<>());
            mapLeft.get(k - nums[i]).add(i);
        }
        for (int i = n - 2; i > -1; i--) {
            sumRight[i] = sumRight[i + 1] + nums[i];
            mapRight.putIfAbsent(k - nums[i], new TreeSet<>());
            mapRight.get(k - nums[i]).add(i);
        }
        int ways = 0;
        for (int i = 1; i < n; i++) {
            if (sumLeft[i - 1] == sumRight[i]) {
                ways++;
            } else {
                int diff = sumRight[i] - sumLeft[i - 1];
                if ((mapLeft.containsKey(diff) && mapLeft.get(diff).lower(i) != null)) {
                    ways++;
                }
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(new WaysToPartition().waysToPartition(new int[]{2, -1, 2}, 3));
    }
}
