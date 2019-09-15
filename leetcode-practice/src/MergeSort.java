
public class MergeSort {

	public static void mergesort(int[] arr) {
		int[] helper = new int[arr.length];
		mergesort(arr, helper, 0, arr.length - 1);
	}

	private static void mergesort(int[] arr, int[] helper, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergesort(arr, helper, low, mid);
			mergesort(arr, helper, mid + 1, high);
			merge(arr, helper, low, mid, high);
		}
	}

	private static void merge(int[] arr, int[] helper, int low, int mid, int high) {
		for (int i = low; i < high; i++) {
			helper[i] = arr[i];
		}

		int helperLeft = low;
		int helperRight = mid + 1;
		int current = low;

		while (helperLeft <= mid && helperRight <= high) {
			if (helper[helperLeft] < helper[helperRight]) {
				arr[current] = helper[helperLeft];
				helperLeft++;
			} else {
				arr[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		int remaining = mid - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			arr[current + i] = helper[helperLeft + i];
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 2, 3, 1, 4 };
		mergesort(arr);
		for(int i= 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
