package leetcode;

import java.util.Arrays;

public class RemoveCoveredIntervals {

	public int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int count = 0;
		for (int i = 0; i < intervals.length; i++) {
			for (int j = i + 1; j < intervals.length; j++) {
				int[] a = intervals[i];
				int[] b = intervals[j];
				if ((a[0] >= b[0] && a[1] <= b[1]) || (a[0] <= b[0] && a[1] >= b[1])) {
					count++;
				}
			}
		}

		return intervals.length - count;
	}
}
