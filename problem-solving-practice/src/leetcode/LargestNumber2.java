package leetcode;

import java.util.Arrays;

public class LargestNumber2
{
	public static void main(String[] args)
	{
		System.out.println(new LargestNumber2().largestNumberOptimized(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(new LargestNumber2().largestNumberOptimized(new int[] { 10, 2 }));
		System.out.println(new LargestNumber2().largestNumberOptimized(new int[] { 2, 1 }));
		System.out.println(new LargestNumber2().largestNumberOptimized(new int[] { 128, 12 }));
		System.out.println(new LargestNumber2().largestNumberOptimized(new int[] { 121, 12 }));
	}

	public String largestNumber(int[] nums)
	{
		Integer[] arr = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			arr[i] = nums[i];
		}
		Arrays.sort(arr, (a, b) -> {
			int i = 0;
			int j = 0;
			String aa = String.valueOf(a);
			String bb = String.valueOf(b);
			while (i < aa.length() || j < bb.length())
			{
				if (i == aa.length())
				{
					long x = Long.parseLong(aa + bb);
					long y = Long.parseLong(bb + aa);
					return x > y ? 1 : -1;
				}
				if (j == bb.length())
				{
					int x = Integer.parseInt(aa + bb);
					int y = Integer.parseInt(bb + aa);
					return x > y ? 1 : -1;
				}
				int x = aa.charAt(i);
				int y = bb.charAt(j);
				if (x < y)
				{
					return aa.compareTo(bb);
				}
				if (y < x)
				{
					return aa.compareTo(bb);
				}
				i++;
				j++;
			}
			return bb.length() - aa.length();
		});

		int index = arr.length - 1;
		while (index > 0 && arr[index] == 0)
		{
			index--;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = index; i >= 0; i--)
		{
			sb.append(arr[i]);
		}

		return sb.toString();
	}

	public String largestNumberOptimized(int[] nums)
	{
		String[] arr = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			arr[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(arr, (a, b) -> {
			return (a + b).compareTo(b + a);
		});

		int index = arr.length - 1;
		while (index > 0 && arr[index].equals("0"))
		{
			index--;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = index; i >= 0; i--)
		{
			sb.append(arr[i]);
		}

		return sb.toString();
	}
}
