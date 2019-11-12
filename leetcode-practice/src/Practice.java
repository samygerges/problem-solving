
public class Practice {

	public static void main(String[] args) {
		long a = 6;
		long b = 10;

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + " -- " + b);
	}

}
