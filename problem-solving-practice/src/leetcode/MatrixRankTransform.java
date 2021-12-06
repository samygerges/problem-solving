package leetcode;

import java.util.*;

public class MatrixRankTransform {
    public int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        Map<Integer, List<Integer>> less = new HashMap<>();
        Map<Integer, List<Integer>> greater = new HashMap<>();
        Map<Integer, List<Integer>> equal = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                less.put(i * n + j, new ArrayList<>());
                greater.put(i * n + j, new ArrayList<>());
                equal.put(i * n + j, new ArrayList<>());

                for (int k = j + 1; k < m; k++) {
                    if (matrix[i][j] < matrix[i][k]) {
                        greater.get(i * n + j).add(i * n + k);
                    } else if (matrix[i][j] > matrix[i][k]) {
                        less.get(i * n + j).add(i * n + k);
                    } else {
                        equal.get(i * n + j).add(i * n + k);
                    }
                }
                for (int k = i + 1; k < n; k++) {
                    if (matrix[i][j] < matrix[k][j]) {
                        greater.get(i * n + j).add(k * n + j);
                    } else if (matrix[i][j] > matrix[k][j]) {
                        less.get(i * n + j).add(k * n + j);
                    } else {
                        equal.get(i * n + j).add(k * n + j);
                    }
                }
            }
        }

        int[][] answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(answer[i], 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!less.get(i * n + j).isEmpty()) {
                    answer[i][j]++;
                }

                int max = answer[i][j];
                for (int k : equal.get(i * j)) {
                    int h = k / n;
                    int w = k % n;
                    max = Math.max(answer[h][w], max);
                }
                answer[i][j] = max;
                for (int k : greater.get(i * j)) {
                    int h = k / n;
                    int w = k % n;
                    answer[h][w] = Math.max(answer[h][w], answer[i][j] + 1);
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new MatrixRankTransform().matrixRankTransform(new int[][]{{1, 2}, {3, 4}}));
    }
}
