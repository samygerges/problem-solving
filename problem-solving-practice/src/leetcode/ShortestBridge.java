package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ShortestBridge {
    private final static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestBridge(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Set<int[]> island1 = new HashSet<>();
        Set<int[]> island2 = new HashSet<>();

        boolean first = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j, n, m, first ? island1 : island2);
                    first = false;
                }
            }
        }

        // Get min diffs between each pair
        int min = Integer.MAX_VALUE;
        for (int[] p1 : island1) {
            for (int[] p2 : island2) {
                min = Math.min(min, Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1])- 1);
            }
        }
        return min;
    }

    private void dfs(int[][] grid, boolean[][] visited, int x, int y,
                     int n, int m, Set<int[]> island) {
        visited[x][y] = true;
        island.add(new int[]{x, y});
        for (int[] dir : dirs) {
            if (x + dir[0] < n && x + dir[0] > -1 && y + dir[1] < m && y + dir[1] > -1
                    && !visited[x + dir[0]][y + dir[1]] && grid[x + dir[0]][y + dir[1]] == 1) {
                dfs(grid, visited, x + dir[0], y + dir[1], n, m, island);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new ShortestBridge().shortestBridge(new int[][]{{0, 1}, {1, 0}}));
    }
}
