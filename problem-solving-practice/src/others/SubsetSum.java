package others;

import java.util.Arrays;

public class SubsetSum {

	public static void main(String[] args) {
		System.out.println(subsetSum(new int[] { 1, 2, 3, 4, 5 }, 6));
	}
	// 1 5
	// 1 2 3
	// 2 4

	public static int subsetSum(int[] arr, int val) {
		int count = 0;
		for (int i = 0; i < Math.pow(2, arr.length); i++) {
			int sum = 0;
			int[] sumArr = new int[arr.length];
			int index = 0;
			for (int j = 0; j < arr.length; j++) {
				if ((i & (1 << j)) > 0) {
					sum += arr[j];
					sumArr[index++] = arr[j];
				}
			}
			if (sum == val) {
				count++;
				System.out.print(Integer.toBinaryString(i) + ": ");
				Arrays.stream(sumArr).forEach(k -> System.out.print(k + " "));
				System.out.println();
			}
		}
		return count;
	}
}
