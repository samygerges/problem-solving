package hackerrank;

import java.util.Arrays;

public class OrganizingContainers {

	static String organizingContainers(int[][] container) {
		int n = container.length;
		int[] sum1 = new int[n];
		int[] sum2 = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum1[i] += container[i][j];
				sum2[j] += container[i][j];
			}
		}

		Arrays.sort(sum1);
		Arrays.sort(sum2);

		for (int i = 0; i < n; i++) {
			if (sum1[i] != sum2[i]) {
				return "Impossible";
			}
		}
		return "Possible";
	}
}
