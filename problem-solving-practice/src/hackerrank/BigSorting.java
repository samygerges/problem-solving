package hackerrank;

import java.util.Arrays;

public class BigSorting {

	static String[] bigSorting(String[] unsorted) {
		Arrays.sort(unsorted, (a, b) -> {
			if (a.length() == b.length()) {
				return a.compareTo(b);
			}
			return a.length() - b.length();
		});
		
		return unsorted;
	}
}
