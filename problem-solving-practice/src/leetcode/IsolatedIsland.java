package leetcode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsolatedIsland {

	public int getNumOfIsolatedIsland(int[][] arr) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.poll();
		Stack<Integer> rowStack = new Stack<Integer>();
		Stack<Integer> columnStack = new Stack<Integer>();
		boolean[][] visit = new boolean[arr.length][arr[0].length];
		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (!visit[i][j] && arr[i][j] == 1) {
					result++;
					rowStack.push(i);
					columnStack.push(j);
					while (!rowStack.isEmpty() && !columnStack.isEmpty()) {
						int row = rowStack.pop();
						int column = columnStack.pop();
						arr[row][column] = 0;
						visit[row][column] = true;
						// get all neighbors
						if (row + 1 < arr.length && !visit[row + 1][column] && arr[row + 1][column] == 1) {
							rowStack.push(row + 1);
							columnStack.push(column);
						}
						if (row - 1 >= 0 && !visit[row - 1][column] && arr[row - 1][column] == 1) {
							rowStack.push(row - 1);
							columnStack.push(column);
						}
						if (row + 1 < arr.length && column + 1 < arr[0].length && !visit[row + 1][column + 1]
								&& arr[row + 1][column + 1] == 1) {
							rowStack.push(row + 1);
							columnStack.push(column + 1);
						}
						if (row + 1 < arr.length && column - 1 >= 0 && !visit[row + 1][column - 1]
								&& arr[row + 1][column - 1] == 1) {
							rowStack.push(row + 1);
							columnStack.push(column - 1);
						}

						if (row - 1 >= 0 && column + 1 < arr[0].length && !visit[row - 1][column + 1]
								&& arr[row - 1][column + 1] == 1) {
							rowStack.push(row - 1);
							columnStack.push(column + 1);
						}
						if (row - 1 >= 0 && column - 1 >= 0 && !visit[row - 1][column - 1]
								&& arr[row - 1][column - 1] == 1) {
							rowStack.push(row - 1);
							columnStack.push(column - 1);
						}

						if (column + 1 < arr[0].length && !visit[row][column + 1] && arr[row][column + 1] == 1) {
							rowStack.push(row);
							columnStack.push(column + 1);
						}
						if (column - 1 >= 0 && !visit[row][column] && arr[row][column - 1] == 1) {
							rowStack.push(row);
							columnStack.push(column - 1);
						}
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		IsolatedIsland island = new IsolatedIsland();
		System.out.println(island.getNumOfIsolatedIsland(new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } }));
	}
}
