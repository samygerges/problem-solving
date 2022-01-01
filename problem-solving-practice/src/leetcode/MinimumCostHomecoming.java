package leetcode;

import java.util.ArrayDeque;

public class MinimumCostHomecoming {

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int rowStart = homePos[0] > startPos[0] ? startPos[0] + 1 : homePos[0];
        int rowEnd = homePos[0] > startPos[0] ? homePos[0] : startPos[0] - 1;

        int colStart = homePos[1] > startPos[1] ? startPos[1] + 1 : homePos[1];
        int colEnd = homePos[1] > startPos[1] ? homePos[1] : startPos[1] - 1;

        int res = 0;
        for (int i = rowStart; i <= rowEnd; i++) {
            res += rowCosts[i];
        }

        for (int i = colStart; i <= colEnd; i++) {
            res += colCosts[i];
        }

        return res;
    }

    public int minCostTLE(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int n = rowCosts.length;
        int m = colCosts.length;
        boolean[][] visited = new boolean[n][m];
        long homeCost = Long.MAX_VALUE;
        ArrayDeque<long[]> queue = new ArrayDeque<>();
        long[] start = new long[]{startPos[0], startPos[1], 0};
        queue.add(start);
        while (!queue.isEmpty()) {
            long[] pos = queue.poll();
            int x = (int) pos[0];
            int y = (int) pos[1];
            long cost = pos[2];
            if (x == homePos[0] && y == homePos[1]) {
                homeCost = Math.min(homeCost, cost);
                continue;
            }
            if (x + 1 < n && !visited[x + 1][y] && homeCost > cost + rowCosts[x + 1]
                    && Math.abs(x + 1 - homePos[0]) < Math.abs(x - homePos[0])) {
                queue.add(new long[]{x + 1, y, cost + rowCosts[x + 1]});
                visited[x + 1][y] = true;
            }
            if (x - 1 >= 0 && !visited[x - 1][y] && homeCost > cost + rowCosts[x - 1]
                    && Math.abs(x - 1 - homePos[0]) < Math.abs(x - homePos[0])) {
                queue.add(new long[]{x - 1, y, cost + rowCosts[x - 1]});
                visited[x - 1][y] = true;
            }
            if (y + 1 < m && !visited[x][y + 1] && homeCost > cost + colCosts[y + 1]
                    && Math.abs(y + 1 - homePos[1]) < Math.abs(y - homePos[1])) {
                queue.add(new long[]{x, y + 1, cost + colCosts[y + 1]});
                visited[x][y + 1] = true;
            }
            if (y - 1 >= 0 && !visited[x][y - 1] && homeCost > cost + colCosts[y - 1]
                    && Math.abs(y - 1 - homePos[1]) < Math.abs(y - homePos[1])) {
                queue.add(new long[]{x, y - 1, cost + colCosts[y - 1]});
                visited[x][y - 1] = true;
            }
        }

        return (int) homeCost;
    }
}
