package binarysearch;

import java.util.Arrays;

public class SumOddLengthMedians {
	public static void main(String[] args) {
		// System.out.println(new SumOddLengthMedians().solve(new int[] { 1, 3, 5, 2
		// }));
		System.out.println(new SumOddLengthMedians().solve(new int[] { 2, 2, 0 }));
	}

	public int solve(int[] nums) {
		int answer = 0;
		for (int i = 1; i <= nums.length; i += 2) {
			for (int j = 0; j < nums.length; j++) {
				if (j + i <= nums.length) {
					int[] arr = Arrays.copyOfRange(nums, j, j + i);
					Arrays.sort(arr);
					answer += arr[arr.length / 2];
				}
			}
		}
		return answer;
	}
}
