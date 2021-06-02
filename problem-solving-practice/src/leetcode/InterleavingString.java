package leetcode;

public class InterleavingString
{
	public static void main(String[] args)
	{
		System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

	public boolean isInterleave(String s1, String s2, String s3)
	{
		if (s3.length() != s1.length() + s2.length())
		{
			return false;
		}
		int dp[][] = new int[s1.length()][s2.length()];
		for (int i = 0; i < s1.length(); i++)
		{
			for (int j = 0; j < s2.length(); j++)
			{
				dp[i][j] = -1;
			}
		}
		return isInterleave(s1, 0, s2, 0, s3, 0, dp);
	}

	private boolean isInterleave(String s1, int i, String s2, int j, String s3, int k, int[][] dp)
	{
		if (i == s1.length())
		{
			return s2.substring(j).equals(s3.substring(k));
		}
		if (j == s2.length())
		{
			return s1.substring(i).equals(s3.substring(k));
		}
		if (dp[i][j] > -1)
		{
			return dp[i][j] == 1 ? true : false;
		}
		boolean ans = false;
		if (s3.charAt(k) == s1.charAt(i) && isInterleave(s1, i + 1, s2, j, s3, k + 1, dp) || s3.charAt(k) == s2.charAt(j) && isInterleave(s1, i, s2,
			j + 1, s3, k + 1, dp))
		{
			ans = true;
		}
		dp[i][j] = ans ? 1 : 0;
		return ans;
	}
}
