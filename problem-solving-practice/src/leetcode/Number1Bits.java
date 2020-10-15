package leetcode;

public class Number1Bits {
	public int hammingWeight(int n) {
		int count = 0;
		boolean flag = true;
		if (n < 0) {
			flag = false;
			n = ~n;
		}
		while (n > 0) {
			int bit = n & 1;
			count += (bit | 0);
			n >>= 1;
		}
		return flag ? count : 32 - count;
	}
}
