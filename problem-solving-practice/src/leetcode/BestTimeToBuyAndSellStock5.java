package leetcode;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock5
{
	public static void main(String[] args)
	{
		System.out.println(new BestTimeToBuyAndSellStock5().maxProfit(2, new int[] { 3, 2, 6, 5, 0, 3 }));
	}

	public int maxProfit(int k, int[] prices)
	{
		if (prices == null || prices.length == 0)
		{
			return 0;
		}
		k = k > prices.length / 2 ? prices.length / 2 : k;
		int n = prices.length;
		int[] buy = new int[k + 1];
		int[] sell = new int[k + 1];
		Arrays.fill(buy, Integer.MIN_VALUE);

		for (int i = 0; i < n; i++)
		{
			for (int j = 1; j <= k; j++)
			{
				buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
				sell[j] = Math.max(sell[j], buy[j] + prices[i]);
			}
		}
		return sell[k];
	}
}
