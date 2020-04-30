package hackerrank;

public class SeparateNumbers {

	public static void main(String[] args) {
		separateNumbers("1234");
		separateNumbers("91011");
		separateNumbers("99100");
		separateNumbers("101103");
		separateNumbers("010203");
		separateNumbers("13");
		separateNumbers("1");
	}

	static void separateNumbers(String s) {
		long num = -1;
		int start = 0;
		for (int i = 0; i < s.length() / 2; i++) {
			num = Long.parseLong(s.substring(start, i + 1));
			if (separateNumbers(num + 1, s.replaceFirst("" + num, ""))) {
				break;
			} else {
				num = -1;
			}
		}
		if (num == -1)
			System.out.println("NO");
		else
			System.out.println("YES " + num);
	}

	static boolean separateNumbers(long num, String s) {
		if (s.isEmpty()) {
			return true;
		}
		String numString = "" + num;
		if (s.startsWith(numString))
			return separateNumbers(num + 1, s.replaceFirst(numString, ""));
		return false;
	}

}
