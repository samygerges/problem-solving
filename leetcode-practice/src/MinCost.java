import java.util.Arrays;

public class MinCost {

	public static int mincostTickets(int[] days, int[] costs) {
		int[] dp = new int[days.length];
		Arrays.fill(dp, Integer.MAX_VALUE);

		int[] valid = new int[] { 0, 6, 29 };
		for (int j = 0; j < costs.length; j++) {
			int min = mincostTickets(dp, days, costs, valid, costs[j], 1, days[0] + valid[j]);
			if (min < dp[0])
				dp[0] = min;
		}
		mincostTickets(dp, days, costs, valid, 0, 0, 0);

		return dp[0];
	}

	private static int mincostTickets(int[] dp, int[] days, int[] costs, int[] valid, int cost, int day, int validTo) {
		if (day >= days.length)
			return cost;

		if (days[day] <= validTo) {
			int current = mincostTickets(dp, days, costs, valid, cost, day + 1, validTo);
			if (dp[day] > current)
				dp[day] = current;
			return dp[day];
		}
		if (dp[day] < cost)
			return dp[day];

		for (int i = 0; i < costs.length; i++) {
			int current = mincostTickets(dp, days, costs, valid, costs[i] + cost, day + 1, validTo + valid[i]);
			if (dp[day] > current)
				dp[day] = current;
		}
		return dp[day];
	}

	public static void main(String[] args) {
		System.out.println(mincostTickets(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, new int[] { 2, 7, 15 }));	
	}

}
