package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClimbingLeaderboard {

	public static void main(String[] args) {
		int[] arr = climbingLeaderboard(new int[] { 100, 100, 50, 40, 40, 20, 10 }, new int[] { 5, 25, 50, 120 });
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int[] res = new int[alice.length];
		List<Integer> list = new ArrayList<>();

		int prev = -1;
		for (int i = 0; i < scores.length; i++) {
			if (prev != scores[i])
				list.add(scores[i]);
			prev = scores[i];
		}

		for (int i = 0; i < alice.length; i++) {
			int num = alice[i];
			int index = Collections.binarySearch(list, num, Collections.reverseOrder());
			if (index >= 0) {
				res[i] = index + 1;
			} else {
				index++;
				index *= -1;
				list.add(index, num);
				res[i] = index + 1;
			}
		}
		return res;
	}
}
