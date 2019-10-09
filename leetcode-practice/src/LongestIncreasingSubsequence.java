package main.java.com.leetcode;

class LongestIncreasingSubsequence
{
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[] dp = new int[nums.length];
        int answer = 0;

        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}