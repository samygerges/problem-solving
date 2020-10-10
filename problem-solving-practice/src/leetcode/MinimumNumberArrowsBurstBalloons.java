package leetcode;

import java.util.Arrays;

public class MinimumNumberArrowsBurstBalloons {

	public static void main(String[] args) {
		System.out.println(new MinimumNumberArrowsBurstBalloons()
				.findMinArrowShots(new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }));
		System.out.println(new MinimumNumberArrowsBurstBalloons()
				.findMinArrowShots(new int[][] { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } }));
	}

	public int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		Arrays.sort(points, (a, b) -> {
			if (a[0] < b[0]) {
				return -1;
			}
			if (a[0] > b[0]) {
				return 1;
			}
			return 0;
		});
		int count = 1;
		int[] prev = points[0];
		for (int i = 1; i < points.length; i++) {
			int st = Math.min(prev[1], points[i][0]);
			int end = Math.min(prev[1], points[i][1]);

			if (st >= points[i][0] && points[i][1] >= end) {
				prev[0] = st;
				prev[1] = end;
			} else {
				prev = points[i];
				count++;
			}
		}

		return count;
	}
}
