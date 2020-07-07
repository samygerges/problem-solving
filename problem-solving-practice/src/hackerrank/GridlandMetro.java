package hackerrank;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class GridlandMetro {

	static long gridlandMetro(int n, int m, int k, int[][] track) {
		Map<Integer, Stack<int[]>> map = new HashMap<>();
		for (int i = 0; i < track.length; i++) {
			int r = track[i][0];
			int c1 = track[i][1];
			int c2 = track[i][2];
			Stack<int[]> stack = map.get(r);
			if (stack == null) {
				stack = new Stack<>();
				stack.push(new int[] { c1, c2 });
				map.put(r, stack);
			} else {
				int[] c = stack.peek();
				if (c[1] >= c1)
					c[1] = Math.max(c[1], c2);
				else
					stack.push(new int[] { c1, c2 });
			}
		}
		return (long) n * m - map.values().stream().flatMap(Collection::stream).mapToLong(c -> c[1] - c[0] + 1).sum();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] nmk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nmk[0]);

		int m = Integer.parseInt(nmk[1]);

		int k = Integer.parseInt(nmk[2]);

		int[][] track = new int[k][3];

		for (int i = 0; i < k; i++) {
			String[] trackRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int trackItem = Integer.parseInt(trackRowItems[j]);
				track[i][j] = trackItem;
			}
		}

		long result = gridlandMetro(n, m, k, track);

		System.out.println(String.valueOf(result));

		scanner.close();
	}
}
