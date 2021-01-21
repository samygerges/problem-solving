package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MostCompetitive
{
	public static void main(String[] args)
	{
		Arrays.stream(new MostCompetitive().mostCompetitive(new int[] { 3, 5, 2, 6 }, 2)).forEach(System.out::println);
	}

	public int[] mostCompetitive(int[] nums, int k)
	{
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int n = nums.length;

		for (int i = 0; i < nums.length; i++)
		{
			while (!stack.isEmpty() && nums[i] < nums[stack.peek()] && n - i + stack.size() > k)
			{
				stack.pop();
			}
			if (stack.size() < k)
			{
				stack.push(i);
			}
		}
		int[] ans = new int[k];
		for (int i = k - 1; i >= 0; i--)
		{
			ans[i] = nums[stack.pop()];
		}
		return ans;
	}

	public int[] mostCompetitiveTLE(int[] nums, int k)
	{
		int[] ans = new int[k];
		int n = nums.length;
		int index = 0;
		int current = 0;
		for (int i = 0; i < k; i++)
		{
			int currentMax = Integer.MAX_VALUE;
			for (int j = index; j < n; j++)
			{
				if (nums[j] < currentMax && k - 1 - current < n - j)
				{
					currentMax = nums[j];
					ans[current] = nums[j];
					index = j + 1;
				}
			}
			current++;
		}
		return ans;
	}
}
