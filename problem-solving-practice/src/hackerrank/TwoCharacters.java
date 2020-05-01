package hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoCharacters {
	public static void main(String[] args) {
		System.out.println(alternate("beabeefeab"));
	}

	static int alternate(String s) {
		Set<Character> set = new HashSet<>();
		int max = 0;

		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		List<Character> list = new ArrayList<>(set);
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				max = Math.max(max, getValidString(s, list.get(i), list.get(j)));
			}
		}

		return max;
	}

	private static int getValidString(String str, Character a, Character b) {
		String s = str;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != a && s.charAt(i) != b) {
				s = s.substring(0, i) + s.substring(i + 1);
				i--;
			}
		}

		if (!isValid(s))
			return 0;
		return s.length();
	}

	private static boolean isValid(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}
}
