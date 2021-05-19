package leetcode;

import java.util.Arrays;

public class MinimumMovesEqualArrayElements2
{
	public int minMoves2(int[] nums)
	{
		Arrays.sort(nums);
		int moves = 0;
		for (int i : nums)
		{
			moves += Math.abs(i - nums[nums.length / 2]);
		}
		return moves;
	}
}
