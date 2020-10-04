package leetcode;

import java.util.Arrays;

public class RemoveCoveredIntervals {

	public int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		boolean[] covered = new boolean[intervals.length];
		int count = 0;
		for (int i = 0; i < intervals.length; i++) {
			if (covered[i]) {
				continue;
			}
			for (int j = i + 1; j < intervals.length; j++) {
				if (covered[j]) {
					continue;
				}
				int[] a = intervals[i];
				int[] b = intervals[j];
				if (a[0] >= b[0] && a[1] <= b[1]) {
					covered[i] = true;
					count++;
				} else if (a[0] <= b[0] && a[1] >= b[1]) {
					covered[j] = true;
					count++;
				}
			}
		}

		return intervals.length - count;
	}
} 	
