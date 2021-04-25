package googlecodejam2020Qualification;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Expogo {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			calculate(x, y, i);
		}
		in.close();
	}

	private static void calculate(int x, int y, int t) {
		String xs = Integer.toBinaryString(Math.abs(x));
		String ys = Integer.toBinaryString(Math.abs(y));
		int max = Math.max(xs.length(), ys.length());

		int[] arrx = new int[max + 1];
		int[] arry = new int[max + 1];
		int index = 0;
		for (int i = xs.length() - 1; i >= 0; i--) {
			arrx[index++] = xs.charAt(i) == '1' ? 1 : 0;
		}
		index = 0;
		for (int i = ys.length() - 1; i >= 0; i--) {
			arry[index++] = ys.charAt(i) == '1' ? 1 : 0;
		}

		char[] moves = new char[max + 1];
		boolean invx = false, invy = false;

		for (int i = 0; i < max + 1; i++) {
			if (arrx[i] == 1 && arry[i] == 0) {
				moves[i] = x > 0 ? 'E' : 'W';
			} else if (arrx[i] == 0 && arry[i] == 1) {
				moves[i] = x > 0 ? 'N' : 'S';
			} else if (arrx[i] == 0 && arry[i] == 0) {
				if (i == max) {
					break;
				}
				System.out.println("Case #" + t + ": IMPOSSIBLE");
				return;
			} else {
				int calcx = (int) Math.pow(2, i);
				int fx = (int) Math.pow(2, i + 1);
				for (int j = i - 1; j >= 0; j--) {
					if (moves[j] == 'E' || moves[j] == 'W') {
						calcx += (int) Math.pow(2, j);
						fx -= (int) Math.pow(2, j);
					}
				}
				if (!invx && calcx == fx && arrx[i + 1] == 0) { // can invert x
					arrx[i + 1] = 1;
					invx = true;
					moves[i] = y > 0 ? 'N' : 'S';
					for (int j = i - 1; j >= 0; j--) {
						moves[j] = moves[j] == 'E' ? 'W' : moves[j] == 'W' ? 'E' : moves[j];
					}
				}

				else {
					int calcy = (int) Math.pow(2, i);
					int fy = (int) Math.pow(2, i + 1);
					for (int j = i - 1; j >= 0; j--) {
						if (moves[j] == 'N' || moves[j] == 'S') {
							calcy += (int) Math.pow(2, j);
							fy -= (int) Math.pow(2, j);
						}
					}
					if (!invy && calcy == fy && arry[i + 1] == 0) { // can invert y
						arry[i + 1] = 1;
						invy = true;
						moves[i] = x > 0 ? 'E' : 'W';
						for (int j = i - 1; j >= 0; j--) {
							moves[j] = moves[j] == 'S' ? 'N' : moves[j] == 'N' ? 'S' : moves[j];
						}
					} else {
						System.out.println("Case #" + t + ": IMPOSSIBLE");
						return;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : moves) {
			if (c == '\u0000') {
				break;
			}
			sb.append(c);
		}
		System.out.println("Case #" + t + ": " + sb);
	}
}
