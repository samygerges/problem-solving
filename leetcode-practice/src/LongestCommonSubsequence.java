
public class LongestCommonSubsequence {
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
		System.out.println(longestCommonSubsequence("abc", "abc"));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int[][] dp = new int[text1.length()][text2.length()];

		for (int i = 0; i < text1.length(); i++) {
			dp[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : i - 1 > -1 ? dp[i - 1][0] : 0;
		}
		for (int i = 0; i < text2.length(); i++) {
			dp[0][i] = text2.charAt(i) == text1.charAt(0) ? 1 : i - 1 > -1 ? dp[0][i - 1] : 0;
		}

		for (int i = 1; i < text1.length(); i++) {
			for (int j = 1; j < text2.length(); j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[text1.length() - 1][text2.length() - 1];
	}

}
