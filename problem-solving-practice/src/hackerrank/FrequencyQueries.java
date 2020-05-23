package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {

	static List<Integer> freqQuery(List<List<Integer>> queries) {
		Map<Integer, IntFreq> map = new HashMap<>();
		Map<Integer, Map<Integer, IntFreq>> map2 = new HashMap<>();
		List<Integer> res = new ArrayList<>();
		for (List<Integer> i : queries) {
			if (i.get(0) == 1) {
				int x = i.get(1);
				IntFreq num = map.getOrDefault(x, new IntFreq(x, 0));
				if (num.freq > 0) {
					map2.get(num.freq).remove(num.num);
				}
				num.freq++;
				map.put(x, num);
				if (!map2.containsKey(num.freq)) {
					map2.put(num.freq, new HashMap<>());
				}
				map2.get(num.freq).put(i.get(1), num);
			} else if (i.get(0) == 2) {
				int y = i.get(1);
				if (map.containsKey(y)) {
					map2.get(map.get(y).freq).remove(map.get(y).num);
					map.get(y).freq--;
					if (map.get(y).freq == 0) {
						map.remove(y);
					} else {
						map2.get(map.get(y).freq).put(map.get(y).num, map.get(y));
					}
				}
			} else if (i.get(0) == 3) {
				int z = i.get(1);
				if (map2.containsKey(z) && !map2.get(z).isEmpty()) {
					res.add(1);
				} else {
					res.add(0);
				}
			}
		}
		return res;
	}
}

class IntFreq {
	int num;
	int freq;

	public IntFreq(int num, int freq) {
		this.num = num;
		this.freq = freq;
	}
}