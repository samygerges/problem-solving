package leetcode;

public class PowerOfFour
{
	public static void main(String[] args)
	{
		System.out.println(new PowerOfFour().isPowerOfFourOptimal(16));
	}

	public boolean isPowerOfFour(int num)
	{
		int x = 1;
		while (x < num && x != 0)
		{
			x *= 4;
		}
		return x == num;
	}

	public boolean isPowerOfFourOptimal(int num)
	{
		return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
	}
}
