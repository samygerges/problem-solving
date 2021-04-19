package leetcode;

public class CombinationSum4
{
	public static void main(String[] args)
	{
		System.out.println(new CombinationSum4().combinationSum4(new int[] { 2, 1, 3 }, 35));
	}

	public int combinationSum4(int[] nums, int target)
	{
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i <= target; i++)
		{
			for (int n : nums)
			{
				if (i - n >= 0)
				{
					dp[i] += dp[i - n];
				}
			}
		}
		return dp[target];
	}
}
