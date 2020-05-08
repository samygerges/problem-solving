package others;

import java.util.ArrayList;
import java.util.List;

public class ArrayPremutation {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		permute(nums, new ArrayList<>(), result, 0);
		return result;
	}

	public void permute(int[] nums, List<Integer> pre, List<List<Integer>> result, int len) {
		if (pre.size() == nums.length) {
			result.add(new ArrayList<Integer>(pre));
			return;
		}

		ArrayList<Integer> prefix = new ArrayList<>(pre);
		for (int i = 0; i <= len; i++) {
			prefix.add(i, nums[len]);
			permute(nums, prefix, result, len + 1);
			prefix.remove(i);
		}
	}

	public static void main(String[] args) {
		ArrayPremutation a = new ArrayPremutation();
		System.out.println(a.permute(new int[] { 1, 2, 3 }));
	}
}