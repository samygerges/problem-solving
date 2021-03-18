package leetcode;

public class WiggleSubsequence
{
	public static void main(String[] args)
	{
		System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
	}

	public int wiggleMaxLength(int[] nums)
	{
		if (nums.length <= 1)
		{
			return nums.length;
		}
		int[][] dp = new int[nums.length][2];
		dp[0][0] = 1;
		dp[0][1] = -1;

		int max = 1;

		for (int i = 1; i < nums.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (nums[i] - nums[j] > 0)
				{
					dp[i][0] = Math.max(dp[i][0], Math.abs(dp[j][1]) + 1);
				}
				else if (nums[i] - nums[j] < 0)
				{
					dp[i][1] = Math.max(Math.abs(dp[i][1]), dp[j][0] + 1);
					if (dp[i][1] > 0)
					{
						dp[i][1] *= -1;
					}
				}
			}
			max = Math.max(max, Math.abs(dp[i][0]));
			max = Math.max(max, Math.abs(dp[i][1]));
		}
		return max;
	}
}
