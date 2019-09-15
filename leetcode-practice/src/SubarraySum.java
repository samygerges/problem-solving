import java.util.HashMap;

public class SubarraySum {

	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(k, 0);
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(k - nums[i])) {
				map.put(k, map.get(k) + 1);
			}
			if (!map.containsKey(nums[i]))
				map.put(nums[i], 0);
			map.put(nums[i], map.get(nums[i]) + 1);
		}
		return map.get(k);
	}

	public static void main(String[] args) {
		SubarraySum s = new SubarraySum();
		System.out.println(s.subarraySum(new int[] { 100, 1, 2, 3, 100, 1, 2, 3, 4 }, 3));
	}

}
