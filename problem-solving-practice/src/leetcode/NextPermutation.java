package leetcode;

import java.util.Arrays;

public class NextPermutation
{
	public static void main(String[] args)
	{
		int[] arr = new int[] { 1, 3, 2 };
		new NextPermutation().nextPermutation(arr);
		Arrays.stream(arr).forEach(System.out::print);
	}

	public void nextPermutation(int[] nums)
	{
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i])
		{
			i--;
		}
		if (i >= 0)
		{
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i])
			{
				j--;
			}
			swap(nums, i, j);
		}

		reverse(nums, i + 1);
	}

	private void reverse(int[] nums, int from)
	{
		int i = from;
		int j = nums.length - 1;
		while (i < j)
		{
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] nums, int i, int j)
	{
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
