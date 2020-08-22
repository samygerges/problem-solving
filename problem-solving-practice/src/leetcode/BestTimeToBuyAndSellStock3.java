package leetcode;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock3 {
	public static void main(String[] args) {
		System.out.println(new BestTimeToBuyAndSellStock3().maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int n = prices.length;
		int buy1 = -prices[0];
		int sell1 = 0;
		int buy2 = -prices[0];
		int sell2 = 0;
		for (int i = 1; i < n; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}

		return sell2;
	}
}
