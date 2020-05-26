package hackerrank;

public class ArrayManipulation {

	static long arrayManipulation(int n, int[][] queries) {
		long[] arr = new long[n + 1];
		for (int i = 0; i < queries.length; i++) {
			int a = queries[i][0];
			int b = queries[i][1];
			int k = queries[i][2];
			arr[a] += k;
			if (b + 1 < arr.length) {
				arr[b + 1] -= k;
			}
		}

		long max = 0;
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += arr[i];
			max = Math.max(max, sum);
		}
		return max;
	}
}
