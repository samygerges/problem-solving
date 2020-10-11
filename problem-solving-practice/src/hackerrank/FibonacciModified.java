package hackerrank;

import java.math.BigInteger;

public class FibonacciModified
{
	static BigInteger fibonacciModified(int t1, int t2, int n)
	{
		BigInteger[] dp = new BigInteger[n];
		dp[0] = BigInteger.valueOf(t1);
		dp[1] = BigInteger.valueOf(t2);
		for (int i = 2; i < n; i++)
		{
			dp[i] = dp[i - 1].pow(2).add(dp[i - 2]);
		}
		return dp[n - 1];
	}
}
