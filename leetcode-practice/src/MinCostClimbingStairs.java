
public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		if (cost == null || cost.length == 0 || cost.length == 1)
			return 0;

		int[] dp = new int[cost.length];
		dp[0] = minCost(cost, dp, 0);
		dp[1] = minCost(cost, dp, 1);
		return Math.min(dp[0], dp[1]);
	}

	private int minCost(int[] cost, int[] dp, int st) {
		if (st >= cost.length)
			return 0;
		if (dp[st] != 0)
			return dp[st];
		dp[st] = Math.min(minCost(cost, dp, st + 1), minCost(cost, dp, st + 2)) + cost[st];
		return dp[st];
	}

	public static void main(String[] args) {
		MinCostClimbingStairs a = new MinCostClimbingStairs();
		System.out.println(a.minCostClimbingStairs(new int[] { 10, 15, 20 }));
	}
}
