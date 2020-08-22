package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumLoss {

	static long minimumLoss(long[] price) {
		long min = Long.MAX_VALUE;
		List<Long> list = new ArrayList<>();
		for (long i : price) {
			list.add(i);
		}
		Arrays.sort(price);
		for (int i = price.length - 1; i > 0; i--) {
			int right = list.indexOf(price[i]);
			int left = list.indexOf(price[i - 1]);
			if (right < left && price[i] - price[i - 1] < min) {
				min = price[i] - price[i - 1];
			}
		}
		return min;
	}
}
