package leetcode;

public class NumbersAtMostNGivenDigitSet
{
	public int atMostNGivenDigitSet(String[] D, int N)
	{
		String num = String.valueOf(N);
		int len = num.length();
		int[] dp = new int[len + 1];
		dp[len] = 1;
		for (int i = len - 1; i >= 0; i--)
		{
			int digit = num.charAt(i) - '0';
			for (int j = 0; j < D.length; j++)
			{
				if (Integer.valueOf(D[j]) < digit)
				{
					dp[i] += Math.pow(D.length, len - i - 1);
				}
				else if (Integer.valueOf(D[j]) == digit)
				{
					dp[i] += dp[i + 1];
				}
			}
		}

		for (int i = 1; i < len; i++)
		{
			dp[0] += Math.pow(D.length, i);
		}
		return dp[0];
	}
}
