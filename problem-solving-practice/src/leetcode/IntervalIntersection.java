package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

	public static void main(String[] args) {
		IntervalIntersection l = new IntervalIntersection();
		int[][] A = new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[][] B = new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

		int[][] res = l.intervalIntersection(A, B);
		for (int[] i : res) {
			System.out.println(i[0] + " " + i[1]);
		}
	}

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int[] interval = intervalIntersection(A[i], B[j]);
				if (interval != null) {
					list.add(interval);
				}
			}
		}
		return list.toArray(new int[list.size()][]);
	}

	private int[] intervalIntersection(int[] a, int[] b) {
		int start = Math.max(a[0], b[0]);
		int end = Math.min(a[1], b[1]);

		if (start <= end)
			return new int[] { start, end };

		return null;
	}
}
