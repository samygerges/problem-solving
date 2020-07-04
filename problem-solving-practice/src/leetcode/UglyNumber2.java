package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber2 {
	public static void main(String[] args) {
		UglyNumber2 a = new UglyNumber2();
		System.out.println(a.nthUglyNumber(1600));
	}

	public int nthUglyNumber(int n) {
		List<Long> all = new ArrayList<>();
		all.add(1l);
		long max = 1;
		while (all.size() < n) {
			long candidate = -1;
			for (int i = 0; i < all.size(); i++) {
				if (all.get(i) * 2 > max) {
					candidate = all.get(i) * 2;
					break;
				}
			}
			for (int i = 0; i < all.size(); i++) {
				if (all.get(i) * 3 > max && all.get(i) * 3 < candidate) {
					candidate = all.get(i) * 3;
					break;
				}
			}

			for (int i = 0; i < all.size(); i++) {
				if (all.get(i) * 5 > max && all.get(i) * 5 < candidate) {
					candidate = all.get(i) * 5;
					break;
				}
			}
			all.add(candidate);
			max = candidate;
		}

		return all.get(n - 1).intValue();
	}
}
