package leetcode;

public class Sqrt
{
	public static void main(String[] args)
	{
		Sqrt s = new Sqrt();
		System.out.println(s.mySqrt(2147483647));
	}

	public int mySqrt(int x)
	{
		long left = 0;
		long right = x;
		while (left <= right)
		{
			long mid = left + ((right - left) / 2);
			if (mid * mid == x)
			{
				return (int) mid;
			}
			if ((mid) * (mid) < x && (mid + 1) * (mid + 1) > x)
			{
				return (int) mid;
			}
			if (mid * mid > x)
			{
				right = mid - 1;
			}
			else
			{
				left = mid + 1;
			}
		}
		return 0;
	}
}
