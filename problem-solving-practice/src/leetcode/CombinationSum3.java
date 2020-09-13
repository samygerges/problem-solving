package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum3 {
	public static void main(String[] args) {
		System.out.println(new CombinationSum3().combinationSum3(3, 7));
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		Set<Set<Integer>> res = new HashSet<>();
		backtrack(k, n, new HashSet<>(), res);
		List<List<Integer>> ans = new ArrayList<>();
		for (Set<Integer> s : res) {
			ans.add(new ArrayList<>(s));
		}
		return ans;
	}

	private void backtrack(int k, int n, Set<Integer> set, Set<Set<Integer>> res) {
		if (set.size() == k) {
			int sum = set.stream().reduce(0, (a, b) -> a + b);
			if (sum == n) {
				res.add(new HashSet<>(set));
			}
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if(!set.contains(i)) {
				set.add(i);
				backtrack(k, n, set, res);
				set.remove(i);
			}
		}
	}
}
