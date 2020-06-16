package hackerrank;

public class CounterGame {
	static String counterGame(long n) {
		int counter = 0;
		while (n > 1) {
			long x = sqrt(n);
			if (x == 0) {
				n /= 2;
			} else {
				n = n - x;
			}
			counter++;
		}
		return counter % 2 == 0 ? "Richard" : "Louise";
	}

	static long sqrt(long n) {
		for (int i = 0; i < 64; i++) {
			if (n == Math.pow(2, i)) {
				return 0;
			}
			if (n < Math.pow(2, i)) {
				return (long) Math.pow(2, i - 1);
			}
		}
		return 0;
	}
}
