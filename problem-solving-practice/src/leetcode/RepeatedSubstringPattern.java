package leetcode;

public class RepeatedSubstringPattern {

	public boolean repeatedSubstringPattern(String s) {
		if (s == null)
			return false;
		if (s.length() == 1)
			return false;
		int left = 0;
		int right = 1;
		char[] arr = s.toCharArray();
		while (left < right && left < s.length()) {
			while (right < s.length() && arr[right] != arr[left])
				right++;
			if (right + right - left <= s.length()
					&& !s.substring(left, right).equals(s.substring(right, right + right - left)))
				return false;
			else if (right + right - left > s.length())
				return false;

			left = right;
			right++;
		}
		return true;
	}

	public static void main(String[] args) {
		RepeatedSubstringPattern a = new RepeatedSubstringPattern();
		System.out.println(a.repeatedSubstringPattern("abab"));
	}
}
