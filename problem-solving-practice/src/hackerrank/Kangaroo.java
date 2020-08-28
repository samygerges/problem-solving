package hackerrank;

public class Kangaroo {
	static String kangaroo(int x1, int v1, int x2, int v2) {
		if ((x1 < x2 && v1 <= v2) || (x1 > x2 && v1 >= v2)) {
			return "NO";
		}

		boolean less = x1 < x2;
		while (x1 != x2) {
			if ((x1 < x2) != less) {
				return "NO";
			}
			x1 += v1;
			x2 += v2;
		}
		return "YES";
	}
}
