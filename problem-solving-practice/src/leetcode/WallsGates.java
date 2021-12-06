package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class WallsGates {
    private static final int INF = 2147483647;
    private static final int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    boolean[][] visited = new boolean[n][m];
                    visited[i][j] = true;
                    ArrayDeque<int[]> queue = new ArrayDeque<>(neighbors(n, m, rooms, i, j, visited));
                    int rounds = 1;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size > 0) {
                            int[] pos = queue.poll();
                            visited[pos[0]][pos[1]] = true;
                            if (rooms[pos[0]][pos[1]] != 0) {
                                rooms[pos[0]][pos[1]] = Math.min(rooms[pos[0]][pos[1]], rounds);
                            }
                            queue.addAll(neighbors(n, m, rooms, pos[0], pos[1], visited));
                            size--;
                        }
                        rounds++;
                    }
                }
            }
        }
    }

    private List<int[]> neighbors(int n, int m, int[][] rooms, int i, int j, boolean[][] visited) {
        List<int[]> neighbors = new ArrayList<>();
        for (int[] direction : dir) {
            if (i + direction[0] < n && i + direction[0] > -1
                    && j + direction[1] < m && j + direction[1] > -1
                    && rooms[i + direction[0]][j + direction[1]] != -1
                    && !visited[i + direction[0]][j + direction[1]]) {
                neighbors.add(new int[]{i + direction[0], j + direction[1]});
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{INF, -1, 0, INF},
                {INF, INF, INF, -1}, {INF, -1, INF, -1}, {0, -1, INF, INF}};
        new WallsGates().wallsAndGates(test1);
        for (int[] ints : test1) {
            for (int j = 0; j < test1[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

        System.out.println("-----------------------");
        int[][] test2 = new int[][]{{-1}};
        new WallsGates().wallsAndGates(test2);
        for (int[] ints : test2) {
            for (int j = 0; j < test2[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        int[][] test3 = new int[][]{{INF}};
        new WallsGates().wallsAndGates(test3);
        for (int[] ints : test3) {
            for (int j = 0; j < test3[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        int[][] test4 = new int[][]{{0}};
        new WallsGates().wallsAndGates(test4);
        for (int[] ints : test4) {
            for (int j = 0; j < test4[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
