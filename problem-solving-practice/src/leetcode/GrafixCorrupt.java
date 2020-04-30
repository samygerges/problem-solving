package leetcode;

public class GrafixCorrupt {

	public int selectWord(String[] dictionary, String candidate) {

		if (dictionary == null || dictionary.length == 0)
			return -1;

		int[] arr = new int[dictionary.length];
		int i = 0;
		for (String s : dictionary) {
			arr[i++] = compareStrings(s, candidate);
		}

		int index = -1;
		int max = -1;
		for (i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}

		return index;
	}

	private int compareStrings(String s, String candidate) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == candidate.charAt(i))
				count++;
		}
		return count == 0 ? -1 : count;
	}

}
