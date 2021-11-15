package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> mod = new HashSet<>();
        int currentSum = 0;
        int prevSum = 0;

        for (int num : nums) {
            currentSum += num;
            if (mod.contains(currentSum % k)) {
                return true;
            }
            currentSum %= k;
            mod.add(prevSum);
            prevSum = currentSum;
        }
        return false;
    }

    public boolean checkSubarraySumTLE(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return helper(nums, k, sum, 0, nums.length - 1);
    }

    private boolean helper(int[] nums, int k, long sum, int i, int j) {
        if (sum % k == 0) {
            return true;
        }
        if (i + 1 >= j) {
            return false;
        }
        return helper(nums, k, sum - nums[i], i + 1, j) || helper(nums, k, sum - nums[j], i, j - 1);
    }

    public static void main(String[] args) {
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{1, 0}, 2));
    }
}
