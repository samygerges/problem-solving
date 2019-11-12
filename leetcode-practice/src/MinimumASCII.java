
public class MinimumASCII {

	public int minimumDeleteSum(String s1, String s2) {
		int sum = 0;

		int l = 0;
		int r = s1.length();

		while (l < r) {
			if (s2.contains(s1.substring(l, r))) {
				break;
			} else if (s2.contains(s1.substring(l + 1, r))) {
				l++;
				break;
			} else if (s2.contains(s1.substring(l, r-1))) {
				r--;
				break;
			}
			l++;
            r--;
		}

		sum += calc(s1, l, r);

		l = 0;
		r = s2.length();

		while (l < r) {
			if (s1.contains(s2.substring(l, r))) {
				break;
			} else if (s1.contains(s2.substring(l + 1, r))) {
				l++;
				break;
			} else if (s1.contains(s2.substring(l, r-1))) {
				r--;
				break;
			}
			l++;
            r--;
		}

		sum += calc(s2, l, r);

		return sum;
	}

	private int calc(String s, int l, int r) {
		int sum = 0;
		for (int i = 0; i < l; i++) {
			sum += s.charAt(i);
		}
		for (int i = s.length() - 1; i >= r; i--) {
			sum += s.charAt(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		MinimumASCII m = new MinimumASCII();
		System.out.println(m.minimumDeleteSum("delete", "leet"));
	}

}
