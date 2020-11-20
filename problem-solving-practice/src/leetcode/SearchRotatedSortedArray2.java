package leetcode;

public class SearchRotatedSortedArray2
{
	public boolean search(int[] nums, int target) { // worst case is O(N) anyway
		for(int i : nums) {
			if(i == target) {
				return true;
			}
		}
		return false;
	}
}
