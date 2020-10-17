package binarysearch;

public class RemovingTripleSuccessiveDuplicates {
	public int solve(String s) {
		int count = 0;
		for (int i = 0; i < s.length() - 2; i++) {
			if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i + 2)) {
				count++;
				i += 2;
			}
		}
		return count;
	}
}
