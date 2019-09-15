import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[] res = getNumbers(n);
			System.out.println("Case #" + i + ": " + res[0] + " " + res[1]);
		}
		in.close();
	}

	public static int[] getNumbers(int n) {
		int[] res = new int[2];

		int a = n / 3;
		int b = n - a;
		String aa = "" + a;
		String bb = "" + b;

		while (aa.contains("4") || bb.contains("4")) {
			a = a / 3;
			b = n - a;
			aa = "" + a;
			bb = "" + b;
		}

		res[0] = a;
		res[1] = b;
		return res;
	}
}
