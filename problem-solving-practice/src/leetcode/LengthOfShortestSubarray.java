package leetcode;

public class LengthOfShortestSubarray
{
	public static void main(String[] args)
	{
		LengthOfShortestSubarray a = new LengthOfShortestSubarray();

		//System.out.println(a.findLengthOfShortestSubarray(new int[] { 1, 2, 3, 10, 4, 2, 3, 5 }));
		//System.out.println(a.findLengthOfShortestSubarray(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(a.findLengthOfShortestSubarray(new int[] { 0, 16, 3, 13, 14, 11, 1, 24, 20, 20, 18, 15, 20 }));
		//System.out.println(a.findLengthOfShortestSubarray(new int[] { 10, 13, 17, 21, 15, 15, 9, 17, 22, 22, 13 }));
	}

	public int findLengthOfShortestSubarray(int[] arr)
	{
		int[] dp = new int[arr.length];
		int max = -1;
		int index = -1;
		int maxIndex = -1;
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i] < arr[i - 1] && max == -1)
			{
				max = arr[i - 1];
				index = i - 1;
				dp[i] = 1;
			}
			else
			{
				if (arr[i] < max && index - 1 >= 0 && arr[i] >= arr[index - 1])
				{
					max = arr[index - 1];
					dp[index] = 1;
					maxIndex = i;

				}
				if (maxIndex != -1 && arr[i] > arr[maxIndex])
				{
					maxIndex = i;
				}
				if (arr[i] < arr[i - 1] && dp[i - 1] == 0)
				{
					dp[i - 1] = 1;
				}
				if (arr[i] < max)
				{
					dp[i] = 1;
				}
			}
		}

		int start = -1;
		int end = -1;
		for (int i = 0; i < dp.length; i++)
		{
			if (dp[i] == 1 && start == -1)
			{
				start = i;
				end = i;
			}
			else if (dp[i] == 1)
			{
				end = i;
			}
		}
		if (maxIndex < end && maxIndex != -1)
		{
			end--;
		}

		return start != -1 && end != -1 ? end - start + 1 : 0;
	}
}
