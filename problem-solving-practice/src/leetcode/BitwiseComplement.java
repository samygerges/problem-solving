package leetcode;

public class BitwiseComplement
{
	public static void main(String[] args)
	{
		System.out.println(new BitwiseComplement().bitwiseComplement(0));
	}

	public int bitwiseComplement(int N)
	{
		if (N == 0)
		{
			return 1;
		}
		int bits = (int) (Math.log(N) / Math.log(2) + 1);
		String ones = "";
		for (int i = 0; i < bits; i++)
		{
			ones += "1";
		}
		int tmp = Integer.parseInt(ones, 2);
		return tmp - N;
	}
}
