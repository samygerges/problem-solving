package leetcode;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class RandomPickWithWeight {

	public static void main(String[] args) {
		RandomPickWithWeight r = new RandomPickWithWeight(new int[] { 1 });
		System.out.println(r.pickIndex());
	}

	private final NavigableMap<Integer, Integer> map = new TreeMap<>();
	private final Random rand;
	private int total = 0;

	public RandomPickWithWeight(int[] w) {
		rand = new Random();
		for (int i = 0; i < w.length; i++) {
			total += w[i];
			map.put(total, i);
		}
	}

	public int pickIndex() {
		int value = rand.nextInt(total);
		return map.higherEntry(value).getValue();
	}
}
