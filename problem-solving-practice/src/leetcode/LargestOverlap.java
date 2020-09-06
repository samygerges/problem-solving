package leetcode;

public class LargestOverlap {
	public static void main(String[] args) {
		System.out.println(new LargestOverlap().largestOverlap(new int[][] { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } },
				new int[][] { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 1 } }));
	}

	public int largestOverlap(int[][] A, int[][] B) {
		int ans = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int current1 = 0;
				int current2 = 0;
				for (int x = i; x < n; x++) {
					for (int y = j; y < n; y++) {
						if (B[x][y] == 1 && A[x - i][y - j] == 1) {
							current1++;
						}
						if (A[x][y] == 1 && B[x - i][y - j] == 1) {
							current2++;
						}
					}
				}
				int current = Math.max(current1, current2);
				ans = Math.max(ans, current);
			}
		}

		return ans;
	}
}
