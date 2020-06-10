package hackerrank;

public class Abbreviation {

	public static void main(String[] args) {
		System.out.println(abbreviation("bBccC", "BBC"));
	}

	static String abbreviation(String a, String b) {
		return sub(a, b) ? "YES" : "NO";
	}

	static boolean sub(String a, String b) {
		boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
		dp[0][0] = true;
		boolean isUpper = false;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) < 'a' || isUpper) {
				isUpper = true;
				dp[i + 1][0] = false;
			} else {
				dp[i + 1][0] = true;
			}
		}

		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j];
				} else if (a.charAt(i) < 'a') {
					dp[i + 1][j + 1] = false;
				} else if (Character.toUpperCase(a.charAt(i)) == b.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] || dp[i][j + 1];
				} else {
					dp[i + 1][j + 1] = dp[i][j + 1];
				}
			}
		}

		return dp[a.length()][b.length()];
	}
}
