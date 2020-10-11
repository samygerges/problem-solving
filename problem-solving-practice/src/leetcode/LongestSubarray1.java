package leetcode;

public class LongestSubarray1
{
	public static void main(String[] args)
	{
		LongestSubarray1 a = new LongestSubarray1();
		System.out.println(a.longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 }));
	}

	public int longestSubarray(int[] nums)
	{
		int max = 0;
		int[] dp = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] == 1)
			{
				dp[i + 1] = dp[i] + 1;
			}
		}
		for (int i = dp.length - 2; i > -1; i--)
		{
			if (dp[i] > 0 && dp[i + 1] > 0)
			{
				dp[i] = dp[i + 1];
			}
		}
		for (int i = 1; i < dp.length - 1; i++)
		{
			if (dp[i] == 0)
			{
				max = Math.max(dp[i - 1] + dp[i + 1], max);
			}
			else
			{
				max = Math.max(dp[i], max);
			}
		}
		return max == nums.length ? max - 1 : max;
	}
}
