package leetcode;

public class LongestPalindromeSubseq {
	public static void main(String[] args) {
		System.out.println(new LongestPalindromeSubseq().longestPalindromeSubseq("bbbab"));
		System.out.println(new LongestPalindromeSubseq().longestPalindromeSubseq("cbabc"));
	}

	public int longestPalindromeSubseq(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] dp = new int[s.length()];
		dp[0] = 1;

		int max = 1;
		for (int i = 1; i < s.length(); i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
