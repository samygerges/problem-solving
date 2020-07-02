package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	public static void main(String[] args) {
		ReconstructItinerary r = new ReconstructItinerary();
		String[][] arr = new String[][] { { "EZE", "TIA" }, { "EZE", "HBA" }, { "AXA", "TIA" }, { "JFK", "AXA" },
				{ "ANU", "JFK" }, { "ADL", "ANU" }, { "TIA", "AUA" }, { "ANU", "AUA" }, { "ADL", "EZE" },
				{ "ADL", "EZE" }, { "EZE", "ADL" }, { "AXA", "EZE" }, { "AUA", "AXA" }, { "JFK", "AXA" },
				{ "AXA", "AUA" }, { "AUA", "ADL" }, { "ANU", "EZE" }, { "TIA", "ADL" }, { "EZE", "ANU" },
				{ "AUA", "ANU" } };
		List<List<String>> list = new ArrayList<>();
		for (String[] array : arr) {
			list.add(Arrays.asList(array));
		}
		System.out.println(r.findItinerary(list));
	}

	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (List<String> s : tickets) {
			map.putIfAbsent(s.get(0), new PriorityQueue<>());
			map.get(s.get(0)).add(s.get(1));
		}

		List<String> res = new ArrayList<>();
		backtrack("JFK", map, res);
		Collections.reverse(res);
		return res;
	}

	private void backtrack(String dest, Map<String, PriorityQueue<String>> map, List<String> res) {
		PriorityQueue<String> queue = map.get(dest);
		while (queue != null && !queue.isEmpty()) {
			backtrack(queue.poll(), map, res);
		}
		res.add(dest);
	}
}
