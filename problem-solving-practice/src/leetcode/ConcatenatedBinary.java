package leetcode;

public class ConcatenatedBinary
{
	public static void main(String[] args)
	{
		System.out.println(new ConcatenatedBinary().concatenatedBinary(12));
	}

	public int concatenatedBinary(int n)
	{
		int mod = (int) (Math.pow(10, 9) + 7);

		long result = 0;
		for (int i = 1; i <= n; i++)
		{
			result = (result * (int) Math.pow(2, Integer.toBinaryString(i).length()) + i) % mod;
		}

		return (int) result;
	}
}
