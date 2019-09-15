
public class TimeSellStock {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;

		int[] dp = new int[prices.length];
		dp[0] = -prices[0];
		int hold = 0;
		for (int i = 1; i < prices.length; i++) {
			dp[i] = Math.max(dp[i - 1] + prices[i] - hold, -prices[i]);
			hold = -prices[i];
		}
		int max = 0;
		for (int i : dp)
			if (max < i)
				max = i;

		return max;
	}

	public static void main(String[] args) {
		TimeSellStock a = new TimeSellStock();
		System.out.println(a.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}
}
