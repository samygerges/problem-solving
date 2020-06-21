package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationSequence {

	public static void main(String[] args) {
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(9, 305645));
	}

	public String getPermutation(int n, int k) {
		int[] factorial = new int[n];
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			arr.add(i + 1);
			factorial[i] = i == 0 ? 1 : i * factorial[i - 1];
		}

		while (n > 0) {
			int remaining = ((k - 1) % factorial[n - 1]) + 1;
			sb.append(arr.remove(((k - 1) / factorial[n - 1])));
			n--;
			k = remaining;
		}

		return sb.toString();
	}

	public String getPermutationTLE(int n, int k) {
		int[] arr = new int[n];
		for (int i = 1; i <= n; i++) {
			arr[i - 1] = i;
		}

		List<String> result = new ArrayList<>();
		permute(result, new StringBuilder(), arr, new HashSet<>());
		return result.get(k - 1);
	}

	private void permute(List<String> list, StringBuilder prefix, int[] arr, Set<Integer> set) {
		if (prefix.length() == arr.length) {
			list.add(prefix.toString());
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				continue;
			}
			prefix.append(arr[i]);
			set.add(arr[i]);
			permute(list, prefix, arr, set);
			prefix.deleteCharAt((prefix.length() - 1));
			set.remove(arr[i]);
		}
	}
}
