package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
	public static void main(String[] args) {
		System.out.println(new FindAnagrams().findAnagrams("abab", "ab"));
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> ans = new ArrayList<>();

		int[] arr = new int[26];
		for (char c : p.toCharArray()) {
			arr[c - 'a']++;
		}

		int[] anagram = new int[26];
		for (int i = 0; i < s.length(); i++) {
			anagram[s.charAt(i) - 'a']++;
			if (i >= p.length()) {
				anagram[s.charAt(i - p.length()) - 'a']--;
			}
			if (anagram(arr, anagram)) {
				ans.add(i - p.length() + 1);
			}
		}

		return ans;
	}

	private boolean anagram(int[] arr, int[] anagram) {
		for (int i = 0; i < 26; i++) {
			if (arr[i] != anagram[i]) {
				return false;
			}
		}
		return true;
	}
}
