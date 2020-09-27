package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {

	public int minSubarray(int[] nums, int p) {
		int sum = 0;
		for (int i : nums) {
			sum = (sum + i) % p;
		}
		if (sum % p == 0) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		int answer = nums.length;

		int pref = 0;
		for (int i = 0; i < nums.length; i++) {
			pref = (pref + nums[i]) % p;
			int left = (pref - sum + p) % p;
			if (map.containsKey(left)) {
				int l = map.get(left);
				answer = Math.min(answer, i - l + 1);
			}
			map.put(pref, i + 1);
		}

		return answer == nums.length ? -1 : answer;
	}
}
