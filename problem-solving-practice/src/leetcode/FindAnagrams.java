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

		for (int i = 0; i < s.length() - p.length() + 1; i++) {
			int[] anagram = new int[26];
			for (int j = i; j < i + p.length(); j++) {
				anagram[s.charAt(j) - 'a']++;
			}
			if (anagram(arr, anagram)) {
				ans.add(i);
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
