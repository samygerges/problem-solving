package leetcode;

public class CountSubIslands {
    private static final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        int m = grid2[0].length;
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    count += dfs(grid1, grid2, visited, i, j, n, m) ? 1 : 0;
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, boolean[][] visited, int x, int y, int n, int m) {
        visited[x][y] = true;
        boolean check = grid1[x][y] == 1;
        for (int[] dir : directions) {
            if (x + dir[0] < n && x + dir[0] > -1 &&
                    y + dir[1] < m && y + dir[1] > -1 &&
                    !visited[x + dir[0]][y + dir[1]] && grid2[x + dir[0]][y + dir[1]] == 1) {
                check &= dfs(grid1, grid2, visited, x + dir[0], y + dir[1], n, m);
            }
        }
        return check;
    }
}
