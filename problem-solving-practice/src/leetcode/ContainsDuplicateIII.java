package leetcode;

import java.util.TreeMap;

public class ContainsDuplicateIII {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeMap<Long, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			if ((map.ceilingKey(nums[i] * 1l - t * 1l) != null && map.ceilingKey(nums[i] * 1l - t * 1l) <= nums[i])
					|| (map.floorKey(nums[i] * 1l + t * 1l) != null
							&& map.floorKey(nums[i] * 1l + t * 1l) >= nums[i])) {
				return true;
			}
			map.put(nums[i] * 1l, i);
			if (i >= k) {
				map.remove(nums[i - k] * 1l);
			}
		}
		return false;
	}
}
