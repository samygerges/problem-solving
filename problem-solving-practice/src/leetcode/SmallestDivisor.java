package leetcode;

public class SmallestDivisor
{
	public static void main(String[] args)
	{
		System.out.println(new SmallestDivisor().smallestDivisor(new int[] { 1, 2, 5, 9 }, 6));
	}

	public int smallestDivisor(int[] nums, int threshold)
	{
		long div = 0;
		for (int i : nums)
		{
			div = Math.max(div, i);
		}
		long l = 1;
		long r = div;

		long divisor = div;

		while (l <= r)
		{
			long mid = l + (r - l) / 2;
			long currSum = 0;
			for (int i : nums)
			{
				if (i % mid == 0)
				{
					currSum += i / mid;
				}
				else
				{
					currSum += (i / mid) + 1;
				}
			}
			if (currSum <= threshold)
			{
				divisor = Math.min(divisor, mid);
				r = mid - 1;
			}
			else
			{
				l = mid + 1;
			}
		}

		return (int) divisor;
	}
}
