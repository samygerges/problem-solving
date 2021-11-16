package leetcode;

import java.util.Comparator;
import java.util.TreeSet;

public class MedianSlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> minSet = new TreeSet<>(comparator);
        TreeSet<Integer> maxSet = new TreeSet<>(comparator.reversed());

        double[] ans = new double[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (!minSet.remove(i - k)) {
                    maxSet.remove(i - k);
                }
            }
            minSet.add(i);
            maxSet.add(minSet.pollFirst());

            if (maxSet.size() > minSet.size()) {
                minSet.add(maxSet.pollFirst());
            }
            if (i >= k - 1) {
                ans[index++] = k % 2 == 1 ? nums[minSet.first()] * 1.0 : ((long) nums[minSet.first()] + (long) nums[maxSet.first()]) / 2.0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MedianSlidingWindow().medianSlidingWindow(new int[]{2, 2}, 2));
    }
}
