package leetcode;

public class TeemoAttacking {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		int sum = 0;
		int until = 0;
		for (int i = 0; i < timeSeries.length; i++) {
			if (until >= timeSeries[i]) {
				sum += duration - (until - timeSeries[i]);
			} else {
				sum += duration;
			}
			until = Math.max(until, timeSeries[i] + duration);
		}
		return sum;
	}
}
