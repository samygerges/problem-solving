package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges2 {

	public List<String> summaryRanges(int[] nums) {
		List<String> answer = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return answer;
		}

		Integer st = nums[0];
		Integer end = null;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] + 1) {
				end = nums[i];
			} else {
				answer.add(st + (end != null && end.intValue() != st.intValue() ? "->" + end : ""));
				st = nums[i];
				end = null;
			}
		}
		answer.add(st + (end != null && end.intValue() != st.intValue() ? "->" + end : ""));

		return answer;
	}
}
