package hackerrank;

import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

public class QueensAttack2 {
	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
		int ways = 0;
		r_q--;
		c_q--;
		Set<Pair<Integer, Integer>> set = new HashSet<>();
		for (int[] i : obstacles) {
			set.add(new Pair<Integer, Integer>(i[0] - 1, i[1] - 1));
		}
		ways += getHorizontal(n, set, r_q, c_q);
		ways += getVertical(n, set, r_q, c_q);
		ways += getDiagonal(n, set, r_q, c_q);
		return ways;
	}

	static int getHorizontal(int n, Set<Pair<Integer, Integer>> set, int r_q, int c_q) {
		int cells = 0;
		for (int i = c_q + 1; i < n; i++) {
			if (set.contains(new Pair<>(r_q, i))) {
				break;
			}
			cells++;
		}
		for (int i = c_q - 1; i >= 0; i--) {
			if (set.contains(new Pair<>(r_q, i))) {
				break;
			}
			cells++;
		}
		return cells;
	}

	static int getVertical(int n, Set<Pair<Integer, Integer>> set, int r_q, int c_q) {
		int cells = 0;
		for (int i = r_q + 1; i < n; i++) {
			if (set.contains(new Pair<>(i, c_q))) {
				break;
			}
			cells++;
		}
		for (int i = r_q - 1; i >= 0; i--) {
			if (set.contains(new Pair<>(i, c_q))) {
				break;
			}
			cells++;
		}
		return cells;
	}

	static int getDiagonal(int n, Set<Pair<Integer, Integer>> set, int r_q, int c_q) {
		int cells = 0;
		for (int i = 1; i < n; i++) {
			if (r_q + i < n && c_q + i < n) {
				if (set.contains(new Pair<>(r_q + i, c_q + i))) {
					break;
				}
				cells++;
			}
		}
		for (int i = 1; i < n; i++) {
			if (r_q - i >= 0 && c_q - i >= 0) {
				if (set.contains(new Pair<>(r_q - i, c_q - i))) {
					break;
				}
				cells++;
			}
		}

		for (int i = 1; i < n; i++) {
			if (r_q - i >= 0 && c_q + i < n) {
				if (set.contains(new Pair<>(r_q - i, c_q + i))) {
					break;
				}
				cells++;
			}
		}
		for (int i = 1; i < n; i++) {
			if (r_q + i < n && c_q - i >= 0) {
				if (set.contains(new Pair<>(r_q + i, c_q - i))) {
					break;
				}
				cells++;
			}
		}
		return cells;
	}
}
