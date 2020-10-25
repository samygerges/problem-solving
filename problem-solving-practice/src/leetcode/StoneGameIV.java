package leetcode;

import java.util.HashSet;
import java.util.Set;

public class StoneGameIV {

	public static void main(String[] args) {
		System.out.println(new StoneGameIV().winnerSquareGame(1));
	}

	public boolean winnerSquareGame(int n) {
		boolean[] dp = new boolean[n + 1];
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i * i <= n; i++) {
			set.add(i * i);
			dp[i * i] = true;
		}

		dp[1] = true;
		for (int i = 2; i <= n; i++) {
			if (!dp[i]) {
				for (int j : set) {
					if (i - j > 0 && !dp[i - j]) {
						dp[i] = !dp[i - j];
					}
				}
			}
		}

		return dp[n];
	}
}
