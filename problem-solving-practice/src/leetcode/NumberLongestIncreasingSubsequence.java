package leetcode;

public class NumberLongestIncreasingSubsequence
{
	public static void main(String[] args)
	{
		System.out.println(new NumberLongestIncreasingSubsequence().findNumberOfLIS(new int[] { 1, 2, 4, 3, 5, 4, 7, 2 }));
	}

	public int findNumberOfLIS(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}

		int[] dp = new int[nums.length];
		int[] count = new int[nums.length];

		dp[0] = 1;
		count[0] = 1;
		int max = 1;

		for (int i = 1; i < nums.length; i++)
		{
			dp[i] = 1;
			count[i] = 1;
			for (int j = 0; j < i; j++)
			{
				if (nums[i] > nums[j])
				{
					if (dp[i] == dp[j] + 1)
					{
						count[i] += count[j];
					}
					else if (dp[i] < dp[j] + 1)
					{
						count[i] = count[j];
						dp[i] = dp[j] + 1;
					}
				}
			}
			max = Math.max(max, dp[i]);
		}
		int maxCount = 0;
		for (int i = 0; i < count.length; i++)
		{
			if (max == dp[i])
			{
				maxCount += count[i];
			}
		}
		return maxCount;
	}
}
