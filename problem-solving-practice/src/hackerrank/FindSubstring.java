package hackerrank;

import java.util.HashSet;
import java.util.Set;

public class FindSubstring {

	public static void main(String[] args) {
		System.out.println(findSubstring("azerdii", 5));
	}

	public static String findSubstring(String s, int k) {
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		int[] arr = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				arr[i] = 1;
			}
		}

		int startIndex = -1;
		int endIndex = -1;
		int max = 0;
		int len = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (len < k) {
				len++;
			}
			count += arr[i];
			if (len == k) {
				if (count > max) {
					max = count;
					startIndex = i - k + 1;
					endIndex = i;
				}
				count -= arr[i - k + 1];
				len--;
			}
		}
		if (startIndex == -1 || endIndex == -1) {
			return "Not found!";
		}
		return s.substring(startIndex, endIndex + 1);
	}
}
