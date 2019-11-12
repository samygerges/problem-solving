import java.math.BigDecimal;

public class Threads {

	private static boolean descending = false;

	public static void main(String[] args) {
		// System.out.println(compare("123", ""));
		System.out.println(10 * 100 / 530);

	}

	public static int compare(String row1, String row2) {
		BigDecimal value1 = new BigDecimal(row1.equals("") ? "" + Integer.MAX_VALUE : row1);
		BigDecimal value2 = new BigDecimal(row2.equals("") ? "" + Integer.MAX_VALUE : row2);
		return descending ? value2.compareTo(value1) : value1.compareTo(value2);
	}
}
