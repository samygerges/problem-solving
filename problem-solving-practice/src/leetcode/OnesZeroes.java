package leetcode;

public class OnesZeroes
{
	public static void main(String[] args)
	{
		System.out.println(new OnesZeroes().findMaxForm(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3));
	}

	public int findMaxForm(String[] strs, int m, int n)
	{
		if (strs == null || strs.length == 0)
		{
			return 0;
		}
		int[][] count = new int[strs.length][2];
		for (int i = 0; i < strs.length; i++)
		{
			for (char c : strs[i].toCharArray())
			{
				if (c == '0')
				{
					count[i][0]++;
				}
				else
				{
					count[i][1]++;
				}
			}
		}

		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < strs.length; i++)
		{
			for (int j = m; j >= count[i][0]; j--)
			{
				for (int k = n; k >= count[i][1]; k--)
				{
					dp[j][k] = Math.max(dp[j][k], dp[j - count[i][0]][k - count[i][1]] + 1);
				}
			}
		}

		return dp[m][n];
	}
}
