package binarysearch;

public class PieceGrouping {
	public static void main(String[] args) {
		System.out.println(
				new PieceGrouping().solve(new int[][] { { 1 }, { 3, 4 }, { 5, 6 }, { 2 } }, new int[] { 1, 2, 3, 4 }));
	}

	public boolean solve(int[][] pieces, int[] target) {
		if (target.length == 0) {
			return true;
		}
		for (int i = 0; i < pieces.length; i++) {
			boolean[] visited = new boolean[pieces.length];
			if (dfs(pieces, visited, target, 0, i)) {
				return true;
			}
		}
		return false;
	}

	private boolean dfs(int[][] pieces, boolean[] visited, int[] target, int current, int index) {
		if (current == target.length) {
			return true;
		}
		visited[index] = true;
		for (int i = 0; i < pieces[index].length; i++) {
			if (current < target.length && pieces[index][i] == target[current]) {
				current++;
				if (current == target.length && i + 1 == pieces[index].length) {
					return true;
				}
			} else {
				visited[index] = false;
				return false;
			}
		}
		for (int i = 0; i < pieces.length; i++) {
			if (!visited[i]) {
				if (dfs(pieces, visited, target, current, i)) {
					return true;
				}
			}
		}
		return false;
	}
}
