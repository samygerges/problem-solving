package leetcode;

public class MincostTickets
{
	public int mincostTickets(int[] days, int[] costs)
	{
		if (days == null || days.length == 0) {
			return 0;
		}

		int[] dp = new int[days[days.length - 1] + 1];
		boolean[] visited = new boolean[days[days.length - 1] + 1];
		for(int i = 0; i < days.length; i++) {
			visited[days[i]] = true;
		}

		for(int i = 1; i < dp.length; i++) {
			if(!visited[i]) {
				dp[i] = dp[i - 1];
			} else {
				int oneDay = dp[i - 1] + costs[0];
				int sevenDay = dp[Math.max(0, i - 7)] + costs[1];
				int thirtyDay = dp[Math.max(0, i - 30)] + costs[2];
				dp[i] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
			}
		}
		return dp[dp.length - 1];
	}
}
