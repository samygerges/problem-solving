package leetcode;

public class BuddyStrings
{
	public boolean buddyStrings(String A, String B) {
		if(A == null || B == null || A.length() != B.length()) {
			return false;
		}

		int diff = 0;
		char[] a = new char[2];
		char[] b = new char[2];
		for(int i = 0; i < A.length(); i++) {
			if(A.charAt(i) != B.charAt(i)) {
				if(diff > 1) {
					return false;
				}
				a[diff] = A.charAt(i);
				b[diff] = B.charAt(i);
				diff++;
			}
		}
		if(diff == 2) {
			if(a[0] == b[1] && a[1] == b[0]) {
				return true;
			}
		}
		if(diff == 0) {
			int[] arr = new int[26];
			for(char c : A.toCharArray()) {
				if(arr[c - 'a'] > 0) {
					return true;
				}
				arr[c - 'a']++;
			}
		}
		return false;
	}
}
