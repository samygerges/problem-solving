package leetcode;
import java.util.ArrayList;
import java.util.List;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int element : nums) {
			sum += element;
		}
		return canPartition(nums, new ArrayList<Integer>(), 0, sum);
	}

	private boolean canPartition(int[] nums, List<Integer> list, int index, int sum) {
		if (index >= nums.length)
			return false;
		int sumList = sum(list);
		if (sumList * 2 == sum && list.size() < nums.length)
			return true;
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			boolean check = canPartition(nums, list, i+1, sum);
			if (check)
				return true;
			list.remove(list.size() - 1);
		}
		return false;
	}

	private int sum(List<Integer> a) {
		int sum = a.stream().mapToInt(i -> i.intValue()).sum();
		return sum;
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum a = new PartitionEqualSubsetSum();
		System.out.println(a.canPartition(new int[] { 1, 2, 5 }));
	}
}
