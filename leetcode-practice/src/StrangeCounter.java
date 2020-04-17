
public class StrangeCounter {

	public static void main(String[] args) {
		System.out.println(strangeCounter(4));
	}

	static long strangeCounter(long t) {
		long start = 3;

		while (start - 2 < t) {
			start *= 2;
		}
		if (start - 2 > t) {
			start /= 2;
		}

		return start + (start - 2 - t);
	}
}
