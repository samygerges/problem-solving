package others;

import java.util.ArrayDeque;

public class PrintDiagonals {

    public static void main(String[] args) {
        //int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] e = queue.poll();
                if (!visited[e[0]][e[1]]) {
                    visited[e[0]][e[1]] = true;
                    System.out.print(arr[e[0]][e[1]] + " ");
                }
                if (e[1] + 1 < m) {
                    int r = e[0];
                    int c = e[1] + 1;
                    for (int i = c; i >= 0; i--) {
                        if (r < n && !visited[r][i]) {
                            queue.add(new int[]{r, i});
                            r++;
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
