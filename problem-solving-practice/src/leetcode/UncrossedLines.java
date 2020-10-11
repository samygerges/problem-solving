package leetcode;

public class UncrossedLines
{
	public static void main(String[] args)
	{
		System.out.println(new UncrossedLines().maxUncrossedLines(new int[] { 1, 4, 2 }, new int[] { 1, 2, 4 }));
	}

	public int maxUncrossedLines(int[] A, int[] B)
	{
		int[][] dp = new int[A.length + 1][B.length + 1];
		for (int i = 0; i < A.length; i++)
		{
			for (int j = 0; j < B.length; j++)
			{
				if (A[i] == B[j])
				{
					dp[i + 1][j + 1] = dp[i][j] + 1;
				}
				else
				{
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}
		return dp[A.length][B.length];
	}
}
