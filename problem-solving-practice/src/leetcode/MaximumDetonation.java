package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumDetonation {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < bombs.length; i++) {
            map.putIfAbsent(i, new HashSet<>());
            for (int j = i + 1; j < bombs.length; j++) {
                map.putIfAbsent(j, new HashSet<>());
                if (detonate(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1], bombs[i][2])) {
                    map.get(i).add(j);
                }
                if (detonate(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1], bombs[j][2])) {
                    map.get(j).add(i);
                }
            }
        }

        for (int i = 0; i < bombs.length; i++) {
            boolean[] visited = new boolean[bombs.length];
            int current = dfs(map, visited, i);
            max = Math.max(max, current);
        }

        return max;
    }

    private int dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int current) {
        if (visited[current]) return 0;
        visited[current] = true;
        int count = 1;

        for (Integer bomb : graph.get(current)) {
            count += dfs(graph, visited, bomb);
        }

        return count;
    }

    private boolean detonate(int x1, int y1, int x2, int y2, int r) {
        return r * 1.0 >= Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
