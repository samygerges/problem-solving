package hackerrank;

public class SherlockCost
{
	static int cost(int[] B)
	{
		int[][] dp = new int[B.length][2];
		int n = B.length;
		for (int i = 0; i < B.length - 1; i++)
		{
			dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + Math.abs(B[i] - 1));
			dp[i + 1][1] = Math.max(dp[i][0] + Math.abs(B[i + 1] - 1), dp[i][1] + Math.abs(B[i] - B[i + 1]));
		}

		return Math.max(dp[n - 1][0], dp[n - 1][1]);
	}
}
