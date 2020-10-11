package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber3
{
	public int[] singleNumber(int[] nums) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		for(int i : nums) {
			if(!set1.add(i)) {
				set2.remove(i);
			} else {
				set2.add(i);
			}
		}
		int[] res = new int[set2.size()];
		int index = 0;
		for(int i : set2) {
			res[index++] = i;
		}
		return res;
	}
}
