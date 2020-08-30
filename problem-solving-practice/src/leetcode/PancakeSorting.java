package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
	public static void main(String[] args) {
		PancakeSorting p = new PancakeSorting();
		System.out.println(p.pancakeSort(new int[] { 3, 2, 4, 1 }));
	}

	public List<Integer> pancakeSort(int[] A) {
		List<Integer> ans = new ArrayList<>();
		for (int i = A.length - 1; i > 0; i--) {
			int maxIndex = getMaxIndex(A, i);
			reverse(A, maxIndex);
			reverse(A, i);
			ans.add(maxIndex + 1);
			ans.add(i + 1);
		}
		return ans;
	}

	private void reverse(int[] arr, int index) {
		for (int i = 0; i <= index / 2; i++) {
			int tmp = arr[i];
			arr[i] = arr[index - i];
			arr[index - i] = tmp;
		}
	}

	private int getMaxIndex(int[] arr, int limit) {
		int maxIndex = 0;
		for (int i = 1; i <= limit; i++) {
			if (arr[i] > arr[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
