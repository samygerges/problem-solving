package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LargestComponentSize {
	public static void main(String[] args) {
		LargestComponentSize a = new LargestComponentSize();
		System.out.println(a.largestComponentSize(new int[] { 2, 3, 6, 7, 4, 12, 21, 39 }));
	}

	public int largestComponentSize(int[] A) {
		int ret = 0;
		int[] parent = new int[A.length];
		int[] rank = new int[A.length];
		Arrays.fill(parent, -1);
		Arrays.fill(rank, 1);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			int x = A[i];
			for (int j = 2; j * j <= x; j++) {
				if (x % j == 0) {
					if (map.containsKey(j)) {
						union(parent, rank, map.get(j), i);
					} else {
						map.put(j, i);
					}
					if (map.containsKey(x / j)) {
						union(parent, rank, map.get(x / j), i);
					} else {
						map.put(x / j, i);
					}
				}
			}
			if (map.containsKey(x)) {
				union(parent, rank, map.get(x), i);
			} else {
				map.put(x, i);
			}
			ret = Math.max(ret, rank[getParent(parent, i)]);
		}
		return ret;
	}

	private int getParent(int[] parent, int x) {
		if (parent[x] == -1)
			return x;
		return parent[x] = getParent(parent, parent[x]);
	}

	private void union(int[] parent, int[] rank, int x, int y) {
		int parX = getParent(parent, x);
		int parY = getParent(parent, y);
		if (parX == parY)
			return;
		if (rank[parX] >= rank[parY]) {
			rank[parX] += rank[parY];
			parent[parY] = parX;
		} else {
			rank[parY] += rank[parX];
			parent[parX] = parY;
		}
	}

	public int largestComponentSizeTLE(int[] A) {
		int max = 0;
		for (int i : A) {
			max = Math.max(max, i);
		}
		List<Integer> primes = sieveOfEratosthenes(max);
		boolean[][] matrix = new boolean[A.length][A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (findCommonFactor(A[i], A[j], primes) > 1) {
					matrix[i][j] = true;
					matrix[j][i] = true;
				}
			}
		}

		int res = 0;
		for (int i = 0; i < A.length; i++) {
			boolean[] visited = new boolean[A.length];
			visited[i] = true;
			res = Math.max(res, longestPath(matrix, visited, i) + 1);
		}
		return res;
	}

	private int longestPath(boolean[][] matrix, boolean[] visited, int start) {
		int count = 0;

		for (int j = 0; j < matrix.length; j++) {
			if (start == j) {
				continue;
			}
			if (matrix[start][j] && !visited[j]) {
				visited[j] = true;
				count += longestPath(matrix, visited, j) + 1;
			}

		}
		return count;
	}

	private static List<Integer> sieveOfEratosthenes(int n) {
		boolean prime[] = new boolean[n + 1];
		Arrays.fill(prime, true);
		for (int p = 2; p * p <= n; p++) {
			if (prime[p]) {
				for (int i = p * 2; i <= n; i += p) {
					prime[i] = false;
				}
			}
		}
		List<Integer> primeNumbers = new LinkedList<>();
		for (int i = 2; i <= n; i++) {
			if (prime[i]) {
				primeNumbers.add(i);
			}
		}
		return primeNumbers;
	}

	private int findCommonFactor(int a, int b, List<Integer> primes) {
		for (int i = 0; i < primes.size(); i++) {
			if (a % primes.get(i) == 0 && b % primes.get(i) == 0) {
				return primes.get(i);
			}
		}
		return 1;
	}
}
