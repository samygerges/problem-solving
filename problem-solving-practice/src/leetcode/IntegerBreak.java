package leetcode;

public class IntegerBreak {
	public int integerBreak(int n) {
		return integerBreak2(n);
	}

	private int integerBreak2(int n) {
		if (n < 1)
			return Integer.MIN_VALUE;
		int a = 1;
		int b = n - a;
		int sum = a * b;
		int suma = 0, sumb = 0;
		if (a + 1 < n)
			suma = integerBreak2(a + 1);
		if (b - 1 > 0)
			sumb = integerBreak(b - 1);
		sum = Math.max(sum, suma + sumb);
		return sum;
	}

	public static void main(String[] args) {
		IntegerBreak a = new IntegerBreak();
		System.out.println(a.integerBreak(10));
	}
}
