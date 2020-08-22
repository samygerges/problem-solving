package leetcode;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RandomPointRectangles {

	private int[][] rects;
	private int area;
	private Random rand;
	private TreeMap<Integer, Integer> map = new TreeMap<>();

	public RandomPointRectangles(int[][] rects) {
		this.rects = rects;
		this.area = 0;
		this.rand = new Random();
		for (int i = 0; i < rects.length; i++) {
			area += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
			map.put(area, i);
		}
	}

	public int[] pick() {
		int index = map.get(map.ceilingKey(rand.nextInt(area + 1)));
		int[] point = new int[2];
		point[0] = rand.nextInt(rects[index][2] - rects[index][0] + 1) + rects[index][0];
		point[1] = rand.nextInt(rects[index][3] - rects[index][1] + 1) + rects[index][1];
		return point;
	}

	private int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
}
