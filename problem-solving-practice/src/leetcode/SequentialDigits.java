package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {

	public static void main(String[] args) {
		System.out.println(new SequentialDigits().sequentialDigits(1000, 13000));
	}

	public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			int num = i;
			int lastDigit = i;
			while (num <= high) {
				if (lastDigit < 9) {
					num = num * 10 + (lastDigit + 1);
					if (num >= low && num <= high) {
						res.add(num);
					}
					lastDigit++;
				}else {
					break;
				}
			}
		}
		Collections.sort(res);
		return res;
	}
}
