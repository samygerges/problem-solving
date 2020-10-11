package leetcode;

public class BurstBalloons
{
	public int maxCoins(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}
		if (nums.length == 1)
		{
			return nums[0];
		}

		int[][] dp = new int[nums.length][nums.length];
		return maxCoins(nums, dp, 0, nums.length - 1);
	}

	private int maxCoins(int[] nums, int[][] dp, int st, int end)
	{
		if (st > end)
		{
			return 0;
		}
		if (dp[st][end] != 0)
		{
			return dp[st][end];
		}

		int max = nums[st];
		for (int i = st; i <= end; i++)
		{
			int before = st - 1 < 0 ? 1 : nums[st - 1];
			int after = end + 1 == nums.length ? 1 : nums[end + 1];
			int current = maxCoins(nums, dp, st, i - 1) + (before * after * nums[i]) + maxCoins(nums, dp, i + 1, end);
			if (current > max)
			{
				max = current;
			}
		}
		dp[st][end] = max;

		return max;
	}
}
