package leetcode;
import java.util.HashMap;
import java.util.Map;

public class DeleteColumnstoMakeSorted {
	public int minDeletionSize(String[] A) {
		if (A == null || A.length == 0)
			return 0;
		Map<String[], Integer> map = new HashMap<String[], Integer>();
		return delete(A, 0, 0, map);
	}

	private int delete(String[] arr, int st, int count, Map<String[], Integer> map) {
		if (check(arr)) {
			return count;
		}
		if (st >= arr[0].length())
			return Integer.MAX_VALUE;
		if (map.containsKey(arr)) {
			return map.get(arr);
		}

		String[] a = new String[arr.length];
		System.arraycopy(arr, 0, a, 0, arr.length);
		int min = Integer.MAX_VALUE;

		for (int i = st; i < a[0].length(); i++) {
			a = deleteChar(a, i);
			min = Math.min(min, delete(a, i, count + 1, map));
			System.arraycopy(arr, 0, a, 0, arr.length);
		}
		map.put(arr, min);
		return min;
	}

	private String[] deleteChar(String[] arr, int index) {
		int len = arr[0].length();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].substring(0, index) + arr[i].substring(index + 1, len);
		}
		return arr;
	}

	private boolean check(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			char[] c = arr[i].toCharArray();
			for (int j = 0; j < c.length - 1; j++) {
				if (c[j] > c[j + 1])
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		DeleteColumnstoMakeSorted a = new DeleteColumnstoMakeSorted();
		// System.out.println(a.minDeletionSize(new String[] { "babca", "bbazb" }));
		// System.out.println(a.minDeletionSize(new String[] { "edcba" }));
		// System.out.println(a.minDeletionSize(new String[] { "ghi", "def", "abc" }));
		System.out.println(a.minDeletionSize(new String[] { "aaababa", "ababbaa" }));
	}
}
