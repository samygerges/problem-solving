package leetcode;

public class Pattern132 {

	public static void main(String[] args) {
		System.out.println(new Pattern132().find132pattern(new int[] { 3, 5, 0, 3, 4 }));
		System.out.println(new Pattern132().find132pattern(new int[] { -2, 1, 2, -2, 1, 2 }));
	}

	public boolean find132pattern(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}
		int[] prefix = new int[nums.length];

		prefix[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			prefix[i] = Math.min(nums[i], prefix[i - 1]);
		}

		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] > prefix[i - 1]) {
				int j = i + 1;
				while (j < nums.length) {
					if (nums[j] < nums[i] && nums[j] > prefix[i - 1]) {
						return true;
					}
					j++;
				}

			}
		}

		return false;
	}
}
