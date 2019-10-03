
public class MaximumSubarray
{
    public int maxSubArray(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int max = nums[0];
        for (int i = 0; i < nums.length; i++)
        {
            int currentMax = 0;
            for (int j = i; j < nums.length; j++)
            {
                currentMax += nums[j];
                if (currentMax > max)
                {
                    max = currentMax;
                }
            }
        }
        return max;
    }


    public int maxSubArrayOptimized(int[] nums)
    { 
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
