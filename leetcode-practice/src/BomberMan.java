import java.util.Arrays;

public class BomberMan {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			Arrays.stream(
					bomberMan(i, new String[] { ".......", "...O.O.", "....O..", "..O....", "OO...OO", "OO.O..." }))
					.forEach(System.out::println);
		}
	}

	static String[] bomberMan(int n, String[] grid) {
		char[][] arr = new char[grid.length][grid[0].length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = grid[i].toCharArray();
		}

		while (n > 5) {
			n -= 4;
		}

		for (int k = 2; k <= n; k++) {
			if (k % 2 == 0) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						if (arr[i][j] == '.') {
							arr[i][j] = '0';
						} else if (arr[i][j] == '0') {
							arr[i][j] = 'O';
						}
					}
				}
			} else if (k % 2 == 1) {
				boolean bombed = false;
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						if (arr[i][j] == 'O') {
							bombed = true;
							arr[i][j] = '.';
							if (i - 1 >= 0 && arr[i - 1][j] != 'O') {
								arr[i - 1][j] = '.';
							}
							if (i + 1 < arr.length && arr[i + 1][j] != 'O') {
								arr[i + 1][j] = '.';
							}
							if (j - 1 >= 0 && arr[i][j - 1] != 'O') {
								arr[i][j - 1] = '.';
							}
							if (j + 1 < arr[i].length && arr[i][j + 1] != 'O') {
								arr[i][j + 1] = '.';
							}
						}
					}
				}
				if (!bombed) {
					break;
				}
			}
		}

		String[] res = new String[grid.length];
		for (int i = 0; i < arr.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != '.') {
					sb.append('O');
				} else {
					sb.append('.');
				}
			}
			res[i] = sb.toString();
		}
		return res;
	}
}
