package leetcode;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javafx.util.Pair;

public class SummaryRanges {

	TreeMap<Integer, Pair<Integer, Integer>> map = null;

	public SummaryRanges() {
		map = new TreeMap<>();
	}

	public void addNum(int val) {
		if (!map.containsKey(val - 1) && !map.containsKey(val + 1)) {
			map.put(val, new Pair<>(val, val));
		} else {
			// need to find start and end
			int start = val;
			while (map.lowerKey(start) != null && map.lowerKey(start) == start - 1) {
				start = start - 1;
			}

			int end = val;
			while (map.higherKey(end) != null && map.higherKey(end) == end + 1) {
				end = end + 1;
			}

			// update the intervals of all elements between start and end
			for (int i = start; i <= end; i++) {
				map.put(i, new Pair<>(start, end));
			}

		}
	}

	public int[][] getIntervals() {
		List<Pair<Integer, Integer>> all = map.values().stream().distinct().collect(Collectors.toList());
		int[][] res = new int[all.size()][2];
		int index = 0;
		for (Pair<Integer, Integer> pair : all) {
			res[index][0] = pair.getKey();
			res[index][1] = pair.getValue();
			index++;
		}
		return res;
	}
}
