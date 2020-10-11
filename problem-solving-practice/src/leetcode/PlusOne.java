package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PlusOne
{
	public int[] plusOne(int[] digits) {
		List<Integer> num = new ArrayList<>();
		int carry = 1;
		for(int i = digits.length - 1; i >= 0; i--){
			if(digits[i] + carry >= 10) {
				carry = 1;
				num.add(0);
			} else {
				num.add(digits[i] + carry);
				carry = 0;
			}
		}
		if(carry == 1) {
			num.add(1);
		}

		int[] res = new int[num.size()];
		for(int i = 0; i < num.size(); i++) {
			res[num.size() - 1 - i] = num.get(i);
		}
		return res;
	}
}
