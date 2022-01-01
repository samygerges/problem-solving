package leetcode;

public class Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] answer = new int[m][n];
        if (m * n > original.length || m * n < original.length) {
            return new int[][]{};
        }
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = original[index++];
            }
        }

        return answer;
    }
}
