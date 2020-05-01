package leetcode;

public class NumArray {

	int[] dp;
	int[] nums;

	public NumArray(int[] nums) {
		this.nums = nums;
		dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				dp[i] = nums[i];
			} else
				dp[i] = dp[i - 1] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		if (i == j) {
			return nums[i];
		}
		if (i == 0) {
			return dp[j];
		}
		return dp[j] - dp[i - 1];
	}
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */
