package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DetectSquares {
    private final Map<Integer, Map<Integer, Integer>> map;

    public DetectSquares() {
        this.map = new HashMap<>();
    }

    public void add(int[] point) {
        if (!map.containsKey(point[0])) {
            map.put(point[0], new HashMap<>());
        }
        Map<Integer, Integer> xMap = map.get(point[0]);
        xMap.put(point[1], xMap.getOrDefault(point[1], 0) + 1);
    }

    public int count(int[] point) {
        int count = 0;
        Map<Integer, Integer> xMap = map.get(point[0]);
        if (xMap == null) {
            return 0;
        }

        for (int y : xMap.keySet()) {
            if (y != point[1]) {
                int dist = y - point[1];
                if (map.containsKey(point[0] + dist) &&
                        map.get(point[0] + dist).containsKey(point[1]) && map.get(point[0] + dist).containsKey(y)) {
                    int tmpCount = xMap.get(y) * map.get(point[0] + dist).get(point[1]) * map.get(point[0] + dist).get(y);
                    count += tmpCount;
                }
                if (map.containsKey(point[0] - dist) &&
                        map.get(point[0] - dist).containsKey(point[1]) && map.get(point[0] - dist).containsKey(y)) {
                    int tmpCount = xMap.get(y) * map.get(point[0] - dist).get(point[1]) * map.get(point[0] - dist).get(y);
                    count += tmpCount;
                }
            }
        }
        return count;
    }
}
