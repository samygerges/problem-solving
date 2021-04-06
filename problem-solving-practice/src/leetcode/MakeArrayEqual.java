package leetcode;

public class MakeArrayEqual
{
	public int minOperations(int n)
	{
		int target = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = (i << 1) + 1;
			target += arr[i];
		}
		target /= n;
		int count = 0;
		for (int i = 0; i < n / 2; i++)
		{
			count += Math.abs(target - arr[i]);
		}
		return count;
	}
}
