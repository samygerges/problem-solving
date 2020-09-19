package leetcode;

public class SumOddLengthSubarrays {
	public static void main(String[] args) {
		System.out.println(new SumOddLengthSubarrays().sumOddLengthSubarrays(new int[] { 1, 4, 2, 5, 3 }));
	}

	public int sumOddLengthSubarrays(int[] arr) {
		int sum = 0;
		for (int i = 1; i <= arr.length; i += 2) {
			sum += sumArray(arr, i);
		}
		return sum;
	}

	private int sumArray(int[] arr, int len) {
		int sum = 0;
		for (int i = 0; i <= arr.length - len; i++) {
			for (int j = i; j < i + len; j++) {
				sum += arr[j];
			}
		}
		return sum;
	}
}
