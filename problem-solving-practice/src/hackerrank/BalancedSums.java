package hackerrank;

import java.util.List;

public class BalancedSums {

	static String balancedSums(List<Integer> arr) {
		int[] prefixSum = new int[arr.size()];
		int[] suffixSum = new int[arr.size()];
		prefixSum[0] = 0;
		suffixSum[arr.size() - 1] = 0;
		for (int i = 1; i < arr.size(); i++) {
			prefixSum[i] = prefixSum[i - 1] + arr.get(i - 1);
		}
		for (int i = arr.size() - 2; i >= 0; i--) {
			suffixSum[i] = suffixSum[i + 1] + arr.get(i + 1);
		}

		for (int i = 0; i < suffixSum.length; i++) {
			if (suffixSum[i] == prefixSum[i])
				return "YES";
		}
		return "NO";
	}
}
