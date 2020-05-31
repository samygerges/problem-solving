package leetcode;

public class MinDistance {
	public static void main(String[] args) {
		System.out.println(new MinDistance().minDistance("horse", "ros"));
	}

	public int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = word1.length(); i >= 0; i--) {
			for (int j = word2.length(); j >= 0; j--) {
				if (i == word1.length()) {
					dp[i][j] = word2.length() - j;
				} else if (j == word2.length()) {
					dp[i][j] = word1.length() - i;
				} else if (word1.charAt(i) == word2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1])) + 1;
				}
			}
		}
		return dp[0][0];
	}
}
