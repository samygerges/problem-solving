package leetcode;

public class RangeBitwiseAnd
{
	public static void main(String[] args)
	{
		System.out.println(rangeBitwiseAnd(1, 2));
		System.out.println(rangeBitwiseAnd(0, 1));
		System.out.println(rangeBitwiseAnd(5, 7));
		System.out.println(rangeBitwiseAnd(1, 4));
		System.out.println(rangeBitwiseAnd(3, 3));
		System.out.println(rangeBitwiseAnd(6, 7));
		System.out.println(rangeBitwiseAnd(10, 11));
	}

	public static int rangeBitwiseAnd(int m, int n)
	{
		int start = 31;
		while (Math.pow(2, start) > n && start > -1)
		{
			start--;
		}
		int num = 0;

		for (int i = start; i >= 0; i--)
		{
			int current = (int) Math.pow(2, i);
			num += current;

			if (num > m)
			{
				num -= (int) Math.pow(2, i);
				if (num + current >= m && num + current <= n)
				{
					break;
				}
			}
		}

		return num;
	}
}
