package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BagOfTokens {

	public int bagOfTokensScore(int[] tokens, int P) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		Arrays.sort(tokens);
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int i : tokens) {
			queue.add(i);
		}

		int score = 0;

		while (!queue.isEmpty()) {
			if (P >= queue.getFirst()) {
				P -= queue.removeFirst();
				score++;
			} else if (score > 0 && queue.size() > 2) {
				P += queue.removeLast();
				score--;
			} else {
				break;
			}
		}

		return score;
	}

}
