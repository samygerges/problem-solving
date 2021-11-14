package leetcode;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int element : nums) {
            sum += element;
            max = Math.max(max, element);
        }
        if (sum % 2 != 0 || max > sum / 2) return false;
        Boolean[] dp = new Boolean[(sum / 2) + 1];
        return helper(nums, dp, 0, sum / 2);
    }

    private boolean helper(int[] nums, Boolean[] dp, int index, int sum) {
        if (index == nums.length) {
            return sum == 0;
        }
        if (sum < 0) return false;
        if (sum == 0) return true;
        if (dp[sum] != null) return dp[sum];
        return dp[sum] = helper(nums, dp, index + 1, sum - nums[index]) || helper(nums, dp, index + 1, sum);
    }
}
