package leetcode;
import java.util.Arrays;

public class AbsolutePermutation {

	public static void main(String[] args) {
		Arrays.stream(absolutePermutation(100, 2)).forEach(System.out::print);
	}

	static int[] absolutePermutation(int n, int k) {
		int[] nums = new int[n];
		if (k == 0) {
			for (int i = 1; i <= n; i++) {
				nums[i - 1] = i;
			}
		} else if (n % (2 * k) == 0) {
			int num = k;
			for (int i = 1; i <= n; i++) {
				nums[i - 1] = i + num;
				if (i % k == 0) {
					num *= -1;
				}
			}
		} else {
			return new int[] { -1 };
		}

		return nums;
	}
}
