package leetcode;

public class MinimumSumSubarray
{
	public static void main(String[] args)
	{
		System.out.println(new MinimumSumSubarray().minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
	}

	public int minSubArrayLen(int s, int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}
		int[] sums = new int[nums.length];
		sums[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			sums[i] = sums[i - 1] + nums[i];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++)
		{
			for (int j = i; j < nums.length; j++)
			{
				int sum = sums[j] - sums[i] + nums[i];
				if (sum >= s)
				{
					min = Math.min(min, j - i + 1);
				}
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
