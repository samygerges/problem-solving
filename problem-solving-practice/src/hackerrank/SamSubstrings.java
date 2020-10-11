package hackerrank;

import java.math.BigInteger;

public class SamSubstrings
{
	public static void main(String[] args)
	{
		System.out.println(substrings("972698438521"));
	}

	static long substrings(String n)
	{
		BigInteger mod = new BigInteger("10").pow(9).add(new BigInteger("7"));
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i <= n.length(); i++)
		{
			for (int j = 0; j < n.length() - i + 1; j++)
			{
				BigInteger val = new BigInteger(n.substring(j, j + i));
				sum = sum.add(val);
			}
		}
		return sum.mod(mod).intValue();
	}
}
