package leetcode;

import java.util.Arrays;

public class RussianDollEnvelopes
{
	public static void main(String[] args)
	{
		System.out.println(new RussianDollEnvelopes().maxEnvelopes(new int[][] { { 46, 89 }, { 50, 53 }, { 52, 68 }, { 72, 45 }, { 77, 81 } }));
	}

	public int maxEnvelopes(int[][] envelopes)
	{
		if (envelopes == null || envelopes.length == 0)
		{
			return 0;
		}
		int[] dp = new int[envelopes.length];
		Arrays.fill(dp, 1);
		Arrays.sort(envelopes, (a, b) -> {
			if (a[0] == b[0])
			{
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});
		int max = 1;
		for (int i = 0; i < envelopes.length; i++)
		{
			int low = i + 1;
			int high = envelopes.length - 1;
			int mid = low;
			while (low <= high)
			{
				mid = low + (high - low) / 2;
				if (envelopes[mid][0] > envelopes[i][0])
				{
					high = mid - 1;
				}
				else
				{
					low = mid + 1;
				}
			}
			for (int j = low; j < envelopes.length; j++)
			{
				if (envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1])
				{
					dp[j] = Math.max(dp[j], dp[i] + 1);
					max = Math.max(max, dp[j]);
				}
			}
		}

		return max;
	}
}
