package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountSubTrees {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[1]).add(edge[0]);
        }

        int[] answer = new int[n];
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(0, labels, map, answer, visited);

        return answer;
    }

    private Map<Character, Integer> dfs(int current, String labels, Map<Integer, Set<Integer>> map, int[] ans, boolean[] visited) {
        char currentLabel = labels.charAt(current);

        if (!map.containsKey(current) || map.get(current).size() == 0) {
            Map<Character, Integer> result = new HashMap<>();
            result.put(currentLabel, 1);
            ans[current] = 1;
            return result;
        }

        Map<Character, Integer> result = new HashMap<>();
        result.put(currentLabel, 1);
        for (int child : map.get(current)) {
            if (visited[child]) continue;
            visited[child] = true;
            Map<Character, Integer> childResult = dfs(child, labels, map, ans, visited);
            childResult.forEach((key, value) -> result.merge(key, value, Integer::sum));
        }
        ans[current] = result.get(currentLabel);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubTrees().countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed"));
    }
}
