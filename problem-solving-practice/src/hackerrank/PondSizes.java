package hackerrank;
import java.util.ArrayList;
import java.util.List;

public class PondSizes {

	public static List<Integer> getPondSizes(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<>();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0 && !visited[i][j]) {
					int count = compute(matrix, visited, i, j);
					res.add(count);
				}
			}
		}
		return res;
	}

	private static int compute(int[][] matrix, boolean[][] visited, int i, int j) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j] || matrix[i][j] != 0)
			return 0;

		int count = 1;
		visited[i][j] = true;

		for (int r = -1; r <= 1; r++) {
			for (int c = -1; c <= 1; c++) {
				count += compute(matrix, visited, i + r, j + c);
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out
				.println(getPondSizes(new int[][] { { 0, 2, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 1 }, { 0, 1, 0, 1 } }));
	}
}
