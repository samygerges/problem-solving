import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Chapter8 {

	public static long tripleStep(int n) {
		long[] arr = new long[n + 1];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for (int i = 4; i <= n; i++)
			arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
		return arr[n];
	}

	public static long countWays(int n) {
		long[] memo = new long[n + 1];
		Arrays.fill(memo, -1);
		return countWays(n, memo);
	}

	private static long countWays(int n, long[] memo) {
		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;
		else if (memo[n] > -1)
			return memo[n];
		else
			memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
		return memo[n];
	}

	public static Set<String> permutation(String str) {
		Set<String> result = new HashSet<>();
		permutation("", str, result);
		return result;
	}

	private static void permutation(String prefix, String str, Set<String> result) {
		if (str.length() == 0) {
			result.add(prefix);
		}

		for (int i = 0; i < str.length(); i++) {
			permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()), result);
		}

	}

	public static long countCoins(int n) {
		int[] coins = { 1, 5, 10, 25 };
		return countCoins(n, 0, coins, new long[n + 1]);
	}

	private static long countCoins(int n, int current, int[] coins, long[] memo) {
		if (current == n)
			return 1;
		if (current > n)
			return 0;
		if (memo[current] != 0)
			return memo[current];

		for (int j = 1; j <= n; j++) {
			for (int i = 0; i < coins.length; i++) {
				if (current + coins[i] <= n) {
					current += coins[i];
					memo[j] += countCoins(j, current, coins, memo);
					current -= coins[i];
				}
			}
		}

		return memo[n];
	}

	public static int maxConnectedRegion(int[][] arr) {
		boolean[][] visit = new boolean[arr.length][arr[0].length];
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (!visit[i][j]) {
					int result = maxConnectedRegion(arr, i, j, visit);
					max = Math.max(result, max);
				}
			}
		}
		return max;
	}

	public static int maxConnectedRegion(int[][] arr, int i, int j, boolean[][] visit) {
		if (i > arr.length || j > arr[0].length || i < 0 || j < 0 || visit[i][j])
			return 0;
		int count = 1;

		visit[i][j] = true;

		if (j + 1 < arr[0].length && !visit[i][j + 1] && arr[i][j + 1] == arr[i][j]) {
			count += maxConnectedRegion(arr, i, j + 1, visit);
		}
		if (i + 1 < arr.length && !visit[i + 1][j] && arr[i + 1][j] == arr[i][j]) {
			count += maxConnectedRegion(arr, i + 1, j, visit);
		}
		if (j - 1 >= 0 && !visit[i][j - 1] && arr[i][j - 1] == arr[i][j]) {
			count += maxConnectedRegion(arr, i, j - 1, visit);
		}
		if (i - 1 >= 0 && !visit[i - 1][j] && arr[i - 1][j] == arr[i][j]) {
			count += maxConnectedRegion(arr, i - 1, j, visit);
		}

		return count;
	}

	public static void main(String[] args) {
		// System.out.println(tripleStep(37));
		// System.out.println(countWays(37));
		// System.out.println(permutation("SAAY").toString());
		// System.out.println(countCoins(100));
		System.out.println(maxConnectedRegion(new int[][] { { 1, 1, 2, 3 }, { 1, 2, 3, 2 }, { 3, 2, 2, 2 } }));
	}
}
