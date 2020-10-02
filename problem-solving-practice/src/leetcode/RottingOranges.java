package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

	public static void main(String[] args) {
		System.out.println(new RottingOranges().orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
	}

	public int orangesRotting(int[][] grid) {
		int minutes = 0;
		int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int countFresh = 0;
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					queue.add(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					countFresh++;
				}
			}
		}
		while (!queue.isEmpty()) {
			List<int[]> newOranges = new ArrayList<>();
			while (!queue.isEmpty()) {
				int[] pair = queue.remove();
				for (int[] i : dir) {
					int r = i[0] + pair[0];
					int c = i[1] + pair[1];
					if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] == 1) {
						grid[r][c] = 2;
						newOranges.add(new int[] { r, c });
						countFresh--;
					}
				}
			}
			if (!newOranges.isEmpty()) {
				minutes++;
			}
			queue.addAll(newOranges);
		}
		return countFresh == 0 ? minutes : -1;
	}
}
