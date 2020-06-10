package hackerrank;

public class RecursiveDigitSum {

	static int superDigit(String n, int k) {
		long sum = 0;

		for (int j = 0; j < n.length(); j++)
			sum += (n.charAt(j) - '0');

		sum *= k;

		while (sum >= 10) {
			long tmp = sum;
			sum = 0;
			while (tmp > 0) {
				sum += (tmp % 10);
				tmp = tmp / 10;
			}
		}
		return (int) sum;
	}
}
