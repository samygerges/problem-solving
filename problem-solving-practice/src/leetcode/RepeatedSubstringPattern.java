package leetcode;

public class RepeatedSubstringPattern {

	public boolean repeatedSubstringPattern(String s) {
		for (int i = s.length() / 2; i > 0; i--) {
			if (s.length() % i == 0) {
				int inc = 0;
				while (i + inc < s.length() && s.charAt(inc) == s.charAt(i + inc)) {
					inc++;
				}
				if (i + inc == s.length()) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		RepeatedSubstringPattern a = new RepeatedSubstringPattern();
		System.out.println(a.repeatedSubstringPattern("abab"));
	}
}
