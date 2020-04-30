package others;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		// System.out.println(subsets(new int[] { 1, 2, 3 }));
		Random r = new Random();
		System.out.println(r.nextInt(1));
		
		System.out.println(r.nextInt(2));
		
//		System.out.println(r.nextInt(3));
	}
}