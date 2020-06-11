package hackerrank;

import java.util.Arrays;

public class TripleSum {
	public static void main(String[] args) {
		System.out.println(triplets(new int[] { 1, 4, 5 }, new int[] { 2, 3, 3 }, new int[] { 1, 2, 3 }));
	}

	static long triplets(int[] a, int[] b, int[] c) {
		long count = 0;
		int[] a1 = Arrays.stream(a).sorted().distinct().toArray();
		int[] a2 = Arrays.stream(b).sorted().distinct().toArray();
		int[] a3 = Arrays.stream(c).sorted().distinct().toArray();

		for (int i : a2) {
			int ind1 = 0;
			int ind2 = 0;
			for (ind1 = 0; ind1 < a1.length && a1[ind1] <= i; ind1++)
				;

			for (ind2 = 0; ind2 < a3.length && a3[ind2] <= i; ind2++)
				;
			count += (ind1 * ind2);
		}
		return count;
	}
}
