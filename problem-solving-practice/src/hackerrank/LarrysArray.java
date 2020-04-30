package hackerrank;

public class LarrysArray {

	public static void main(String[] args) {
		// System.out.println(larrysArray(new int[] { 3, 1, 2 }));
		// System.out.println(larrysArray(new int[] { 1, 2, 3, 5, 4 }));
		// System.out.println(larrysArray(new int[] { 1, 3, 4, 2 }));
		System.out.println(larrysArray(new int[] { 1, 6, 5, 2, 4, 3 }));
		System.out.println(larrysArray(new int[] { 1, 6, 5, 2, 3, 4 }));
		System.out.println(
				larrysArray(new int[] { 17, 21, 2, 1, 16, 9, 12, 11, 6, 18, 20, 7, 14, 8, 19, 10, 3, 4, 13, 5, 15 }));
	}

	static String larrysArray(int[] A) {
		int lastSortedIndex = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == i + 1) {
				lastSortedIndex = i;
			} else {
				if (i + 2 >= A.length) {
					return "NO";
				}

				if (i + 1 == A[i + 1] || i + 1 == A[i + 2]) {
					int rotate = 0;
					while (A[i] != i + 1 && rotate < 3) {
						int tmp = A[i];
						int tmp2 = A[i + 1];
						A[i] = A[i + 2];
						A[i + 1] = tmp;
						A[i + 2] = tmp2;
						rotate++;
					}
				} else {
					for (int j = i + 3; j < A.length; j++) {
						if (A[j] == i + 1) {
							for (int k = j; k >= 2; k -= 2) {
								if (k >= i && k <= i + 2) {
									break;
								}
								int tmp = A[k - 2];
								int tmp2 = A[k - 1];
								A[k - 2] = A[k];
								A[k - 1] = tmp;
								A[k] = tmp2;
							}
							i--;
							break;
						}
					}
				}

			}
		}
		return lastSortedIndex == A.length - 1 ? "YES" : "NO";
	}
}
