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
                if (rooms[i][j] == INF) {
                    ArrayDeque<int[]> queue = new ArrayDeque<>(neighbors(n, m, rooms, i, j));
                    int rounds = 1;
                    while (!queue.isEmpty()) {
                        boolean found = false;
                        List<int[]> nextRound = new ArrayList<>();
                        while (!queue.isEmpty()) {
                            int[] pos = queue.poll();
                            if (rooms[pos[0]][pos[1]] == 0) {
                                rooms[i][j] = rounds;
                                found = true;
                                break;
                            }
                            nextRound.addAll(neighbors(n, m, rooms, pos[0], pos[1]));
                        }
                        if (found) {
                            break;
                        }
                        rounds++;
                        queue.addAll(nextRound);
                    }
                }
            }
        }
    }

    private List<int[]> neighbors(int n, int m, int[][] rooms, int i, int j) {
        List<int[]> neighbors = new ArrayList<>();
        for (int[] direction : dir) {
            if (i + direction[0] < n && i + direction[0] > -1
                    && j + direction[1] < m && j + direction[1] > -1
                    && rooms[i + direction[0]][j + direction[1]] != -1) {
                neighbors.add(new int[]{i + direction[0], j + direction[1]});
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{INF, -1, 0, INF},
                {INF, INF, INF, -1}, {INF, -1, INF, -1}, {0, -1, INF, INF}};
        new WallsGates().wallsAndGates(test1);
        for (int i = 0; i < test1.length; i++) {
            for (int j = 0; j < test1[0].length; j++) {
                System.out.print(test1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("-----------------------");
        int[][] test2 = new int[][]{{-1}};
        new WallsGates().wallsAndGates(test2);
        for (int i = 0; i < test2.length; i++) {
            for (int j = 0; j < test2[0].length; j++) {
                System.out.print(test2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        int[][] test3 = new int[][]{{INF}};
        new WallsGates().wallsAndGates(test3);
        for (int i = 0; i < test3.length; i++) {
            for (int j = 0; j < test3[0].length; j++) {
                System.out.print(test3[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        int[][] test4 = new int[][]{{0}};
        new WallsGates().wallsAndGates(test4);
        for (int i = 0; i < test4.length; i++) {
            for (int j = 0; j < test4[0].length; j++) {
                System.out.print(test4[i][j] + " ");
            }
            System.out.println();
        }
    }
}
