package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {
	public static void main(String[] args) {
		int[] arr = new int[] { 4, 6, 5, 3, 3, 1 };
		List<Integer> a = new ArrayList<>();
		for (int i : arr)
			a.add(i);
		System.out.println(pickingNumbers(a));
	}

	public static int pickingNumbers(List<Integer> a) {
		int max = 0;
		Collections.sort(a);
		for (int i = 0; i < a.size(); i++) {
			int currentMax = 1;
			for (int j = i + 1; j < a.size(); j++) {
				if (Math.abs(a.get(i) - a.get(j)) <= 1) {
					currentMax++;
				}
			}
			max = Math.max(currentMax, max);
		}
		return max;
	}
}
