package leetcode;

public class LongestArithmeticSeqLength {
    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[nums.length][1001];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int seq = nums[i] - nums[j] + 500;
                dp[i][seq] = Math.max(dp[i][seq], Math.max(dp[j][seq], 1) + 1);
                max = Math.max(max, dp[i][seq]);
            }
        }
        return max;
    }
}
