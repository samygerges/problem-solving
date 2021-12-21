package leetcode;

import java.util.*;

public class TimeNeededToInformAllEmployees {
    private int max = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
        }
        dfs(headID, informTime[headID], map, informTime);
        return max;
    }

    private void dfs(int emp, int currTime, Map<Integer, List<Integer>> map, int[] informTime) {
        List<Integer> subs = map.get(emp);
        if (subs == null) return;

        max = Integer.max(max, currTime);
        for (int sub: subs) {
            dfs(sub, currTime + informTime[sub], map, informTime);
        }
    }
}
