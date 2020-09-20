package hackerrank;

import java.math.BigInteger;

public class ExtraLongFactorials {
	
	public static void main(String[] args) {
		extraLongFactorials(25);
	}
	
	static void extraLongFactorials(int n) {
		BigInteger x = BigInteger.valueOf(n);
		for(int i = n - 1; i >= 1; i--) {
			x = x.multiply(BigInteger.valueOf(i));
		}
		System.out.println(x);
	}
}
