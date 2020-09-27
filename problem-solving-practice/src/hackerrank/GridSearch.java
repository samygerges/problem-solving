package hackerrank;

public class GridSearch {

	static String gridSearch(String[] G, String[] P) {
		for (int i = 0; i < G.length; i++) {
			for (int j = 0; j < G[i].length(); j++) {
				if (G[i].charAt(j) == P[0].charAt(0)) {
					if (match(G, P, i, j)) {
						return "YES";
					}
				}
			}
		}
		return "NO";
	}

	static boolean match(String[] g, String[] p, int r, int c) {
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length(); j++) {
				if (i + r >= g.length || j + c >= g[i + r].length() || g[i + r].charAt(j + c) != p[i].charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}
