package googlecodejam;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int[] test = new int[t];
		String[] paths = new String[t];
		for (int i = 1; i <= t; ++i) {
			test[i - 1] = in.nextInt();
			paths[i - 1] = in.next();
			String res = getPath(test[i - 1], paths[i - 1]);
			System.out.println("Case #" + (i) + ": " + res);
		}
		in.close();
	}

	private static String getPath(int n, String path) {
		boolean[][] arr = new boolean[n][n];
		boolean[][] visited = new boolean[n][n];
		arr[0][0] = true;
		visited[0][0] = true;

		int r = 0;
		int c = 0;
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == 'E') {
				arr[r][c + 1] = true;
				c++;
			} else {
				arr[r + 1][c] = true;
				r++;
			}
		}
		return helper(arr, n, 0, 0, "", visited);
	}

	public static String helper(boolean[][] arr, int n, int r, int c, String path, boolean[][] visited) {
		if (r + 1 == n && c + 1 == n) {
			return path;
		}

		String p1 = null;
		String p2 = null;
		if (r + 1 < n && (!arr[r + 1][c] || !arr[r][c]) && !visited[r + 1][c]) {
			visited[r + 1][c] = true;
			p1 = helper(arr, n, r + 1, c, path + "S", visited);
			if (p1 != null)
				return p1;
		}
		if (c + 1 < n && (!arr[r][c + 1] || !arr[r][c]) && !visited[r][c + 1]) {
			visited[r][c + 1] = true;
			p2 = helper(arr, n, r, c + 1, path + "E", visited);
			if (p2 != null)
				return p2;
		}

		return p1 != null ? p1 : p2;
	}
}
