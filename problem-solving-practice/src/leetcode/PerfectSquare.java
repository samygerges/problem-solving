package leetcode;

public class PerfectSquare {
	public static void main(String[] args) {
		PerfectSquare p = new PerfectSquare();
		System.out.println(p.isPerfectSquare(2147395600));
	}

	public boolean isPerfectSquare(int num) {
		int dividor = 1;
		for (int i = 10; i < 100000; i *= 10) {
			if (num < i * i) {
				break;
			}
			dividor = i;
		}
		int right = num / dividor;
		int left = 1;
		int mid = left + ((right - left) / 2);

		while (left <= right) {
			if (mid * mid == num) {
				return true;
			}
			if (mid * mid > num || mid * mid < 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			mid = left + ((right - left) / 2);
		}
		return false;
	}
}
