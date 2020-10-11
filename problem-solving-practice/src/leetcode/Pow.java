package leetcode;

public class Pow
{
	public double myPow(double x, int n)
	{
		if (n == 0 || x == 1.0)
		{
			return 1.0;
		}

		if (x > 0 && n == Integer.MIN_VALUE)
		{
			return 0;
		}
		if (x < 0 && n == Integer.MIN_VALUE)
		{
			return 1;
		}
		if (x > 0 && n == Integer.MAX_VALUE)
		{
			return 0;
		}
		if (x < 0 && n == Integer.MAX_VALUE)
		{
			return -1;
		}

		boolean neg = false;
		if (n < 0)
		{
			neg = true;
			n *= -1;
		}
		double res = pow(x, n);

		if (neg)
		{
			res = 1.0 / res;
		}
		return res;
	}

	private double pow(double x, int n)
	{
		if (n == 0)
		{
			return 1;
		}
		double res = pow(x, n / 2);
		if (n % 2 == 0)
		{
			return res * res;
		}
		return res * res * x;
	}
}
