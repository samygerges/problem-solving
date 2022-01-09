package leetcode;

import javafx.util.Pair;

import java.util.*;

public class MinimumCostReachDestinationTime {

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int[][] dp = new int[passingFees.length][maxTime + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(new Pair<>(edge[1], edge[2]));
            map.get(edge[1]).add(new Pair<>(edge[0], edge[2]));
        }
        int min = solve(0, 0, maxTime, passingFees, dp, map);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int solve(int node, int time, int maxTime, int[] passingFees, int[][] dp, Map<Integer, List<Pair<Integer, Integer>>> map) {
        if (node == passingFees.length - 1) {
            return time > maxTime ? Integer.MAX_VALUE : passingFees[node];
        }
        if (time > maxTime) {
            return Integer.MAX_VALUE;
        }
        if (dp[node][time] != -1) {
            return dp[node][time];
        }
        int best = Integer.MAX_VALUE;
        if (map.containsKey(node)) {
            for (Pair<Integer, Integer> pair : map.get(node)) {
                int cost = solve(pair.getKey(), time + pair.getValue(), maxTime, passingFees, dp, map);
                if (cost != Integer.MAX_VALUE) {
                    best = Math.min(best, cost + passingFees[node]);
                }
            }
        }
        return dp[node][time] = best;
    }
}
