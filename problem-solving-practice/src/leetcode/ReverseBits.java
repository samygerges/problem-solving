package leetcode;

public class ReverseBits
{
	public static void main(String[] args)
	{
		ReverseBits r = new ReverseBits();
		System.out.println(r.reverseBits(1234567890));
	}

	public int reverseBits(int n)
	{
		return Integer.reverse(n);
	}
}
