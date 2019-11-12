
public class WordSearch {

	public static boolean exist(char[][] board, String word) {
		if (board == null || word == null)
			return false;
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					visited[i][j] = true;
					boolean check = exist(board, "" + board[i][j], word, i, j, 1, visited);
					visited[i][j] = false;
					if (check)
						return true;
				}
			}
		}
		return false;
	}

	public static boolean exist(char[][] board, String prefix, String word, int row, int col, int len,
			boolean[][] visited) {
		if (prefix.length() == word.length()) {
			if (prefix.equals(word))
				return true;
			return false;
		}

		boolean r1 = false, r2 = false, r3 = false, r4 = false;
		if (row - 1 >= 0) {
			if (board[row - 1][col] == word.charAt(len) && !visited[row - 1][col]) {
				visited[row - 1][col] = true;
				r1 = exist(board, prefix + board[row - 1][col], word, row - 1, col, len + 1, visited);
				visited[row - 1][col] = false;
			}
		}
		if (row + 1 < board.length) {
			if (board[row + 1][col] == word.charAt(len) && !visited[row + 1][col]) {
				visited[row + 1][col] = true;
				r2 = exist(board, prefix + board[row + 1][col], word, row + 1, col, len + 1, visited);
				visited[row + 1][col] = false;
			}
		}

		if (col - 1 >= 0) {
			if (board[row][col - 1] == word.charAt(len) && !visited[row][col - 1]) {
				visited[row][col - 1] = true;
				r3 = exist(board, prefix + board[row][col - 1], word, row, col - 1, len + 1, visited);
				visited[row][col - 1] = false;
			}
		}

		if (col + 1 < board[row].length) {
			if (board[row][col + 1] == word.charAt(len) && !visited[row][col + 1]) {
				visited[row][col + 1] = true;
				r4 = exist(board, prefix + board[row][col + 1], word, row, col + 1, len + 1, visited);
				visited[row][col + 1] = false;
			}
		}

		return r1 || r2 || r3 || r4;
	}

	public static void main(String[] args) {
		System.out
				.println(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } },
						"ABCEFSADEESE"));
	}

}
