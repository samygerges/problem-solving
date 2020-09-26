package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class NonDivisibleSubset {

	public static void main(String[] args) {
		ArrayList<Integer> s = new ArrayList<>();
		s.add(1);
		s.add(7);
		s.add(2);
		s.add(4);

		System.out.println(nonDivisibleSubsetOptimized(3, s));
	}

	public static int nonDivisibleSubset(int k, List<Integer> s) {
		int res = 0;
		for (int i = 0; i < s.size(); i++) {
			List<Integer> test = new ArrayList<>();
			test.add(s.get(i));
			for (int j = 0; j < s.size(); j++) {
				if (j == i) {
					continue;
				}
				boolean candidate = true;
				for (int r = 0; r < test.size(); r++) {
					if ((s.get(j) + test.get(r)) % k == 0) {
						candidate = false;
						break;
					}
				}
				if (candidate) {
					test.add(s.get(j));
				}
			}
			System.out.println(test);
			res = Math.max(res, test.size());
		}
		return res;
	}

	public static int nonDivisibleSubsetOptimized(int k, List<Integer> s) {
		int[] remainderArr = new int[k];
		for (Integer each : s) {
			remainderArr[each % k]++;
		}
		int zeroRemainder = remainderArr[0];
		int maxNumberOfDivisibleSet = zeroRemainder > 0 ? 1 : 0;
		for (int i = 1; i <= (k / 2); i++) {
			if (i != k - i)
				maxNumberOfDivisibleSet += Math.max(remainderArr[i], remainderArr[k - i]);
			else
				maxNumberOfDivisibleSet++;
		}

		return maxNumberOfDivisibleSet;
	}
}
