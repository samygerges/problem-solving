package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public static void main(String[] args) {
		int[][] res = new InsertInterval().insert(new int[][] { { 2, 6 }, { 7, 9 } }, new int[] { 15, 18 });
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + " " + res[i][1]);
		}
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> all = new ArrayList<>();
		for (int[] interval : intervals) {
			all.add(interval);
		}

		boolean added = false;
		for (int i = 0; i < all.size(); i++) {
			if (all.get(i)[0] <= newInterval[0] && all.get(i)[1] >= newInterval[1]) {
				all.add(i + 1, newInterval);
				added = true;
				break;
			} else if (all.get(i)[0] > newInterval[0]) {
				all.add(i, newInterval);
				added = true;
				break;
			}
		}

		if (!added) {
			all.add(newInterval);
		}

		mergeIntervals(all);

		int[][] res = new int[all.size()][2];
		for (int i = 0; i < all.size(); i++) {
			res[i] = new int[2];
			res[i][0] = all.get(i)[0];
			res[i][1] = all.get(i)[1];
		}
		return res;
	}

	private void mergeIntervals(List<int[]> all) {
		for (int i = 0; i < all.size() - 1; i++) {
			if (all.get(i)[1] >= all.get(i + 1)[0]) {
				int[] interval = new int[] { Math.min(all.get(i)[0], all.get(i + 1)[0]),
						Math.max(all.get(i)[1], all.get(i + 1)[1]) };
				all.remove(i);
				all.remove(i);
				all.add(i, interval);
				i--;
			}
		}
	}
}
