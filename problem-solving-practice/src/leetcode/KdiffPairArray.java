package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KdiffPairArray {

	public static void main(String[] args) {
		System.out.println(new KdiffPairArray().findPairs(new int[] { 3, 1, 4, 1, 5 }, 2));
	}

	public int findPairs(int[] nums, int k) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.putIfAbsent(nums[i], new ArrayList<>());
			map.get(nums[i]).add(i);
		}

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int remain = k + nums[i];
			if (map.containsKey(remain)) {
				for (int j = 0; j < map.get(remain).size(); j++) {
					if (map.get(remain).get(j) != i) {
						count++;
						map.remove(remain);
						break;
					}
				}
			}
		}
		return count;
	}
}
