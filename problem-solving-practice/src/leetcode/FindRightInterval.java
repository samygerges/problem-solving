package leetcode;

import java.util.Arrays;
import java.util.TreeMap;

public class FindRightInterval
{
	public int[] findRightInterval(int[][] intervals) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for(int i = 0; i < intervals.length; i++) {
			map.put(intervals[i][0], i);
		}

		int[] res = new int[intervals.length];
		Arrays.fill(res, -1);
		for(int i = 0; i < res.length; i++) {
			if(map.containsKey(intervals[i][1])) {
				res[i] = map.get(intervals[i][1]);
			} else if (map.higherKey(intervals[i][1]) != null) {
				res[i] = map.get(map.higherKey(intervals[i][1]));
			}
		}
		return res;
	}
}
