package hackerrank;

public class AlmostSorted {
	public static void main(String[] args) {
		almostSorted(new int[] { 1, 5, 4, 3, 2, 6 });
	}

	static void almostSorted(int[] arr) {
		int startIndex = -1;
		int lastIndex = -1;

		// check sorted
		if (sorted(arr)) {
			System.out.println("yes");
			return;
		}
		// check reverse
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				if (startIndex == -1) {
					startIndex = i;
				}
				lastIndex = i + 1;
			}
		}
		// check swap
		int tmp = arr[startIndex];
		arr[startIndex] = arr[lastIndex];
		arr[lastIndex] = tmp;
		if (sorted(arr)) {
			System.out.println("yes");
			System.out.println("swap " + (startIndex + 1) + " " + (lastIndex + 1));
			return;
		}
		tmp = arr[startIndex];
		arr[startIndex] = arr[lastIndex];
		arr[lastIndex] = tmp;

		if (checkReverse(arr, startIndex, lastIndex)) {
			System.out.println("yes");
			System.out.println("reverse " + (startIndex + 1) + " " + (lastIndex + 1));
			return;
		}

		System.out.println("no");
	}

	private static boolean checkReverse(int[] arr, int startIndex, int lastIndex) {
		int[] arr2 = new int[arr.length];
		for (int i = 0; i < startIndex; i++) {
			arr2[i] = arr[i];
		}
		for (int i = lastIndex + 1; i < arr.length; i++) {
			arr2[i] = arr[i];
		}
		int index = startIndex;
		for (int i = lastIndex; i >= startIndex; i--) {
			arr2[index++] = arr[i];
		}
		if (sorted(arr2)) {
			return true;
		}
		return false;
	}

	private static boolean sorted(int[] arr2) {
		for (int i = 0; i < arr2.length - 1; i++) {
			if (arr2[i + 1] < arr2[i]) {
				return false;
			}
		}
		return true;
	}

}
