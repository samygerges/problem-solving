package leetcode;

public class SumOfBeauties {
    public int sumOfBeauties(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            left[i] = Math.max(nums[i], left[i - 1]);
        }
        for (int i = nums.length - 2; i > -1; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }
        int sum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > left[i - 1] && nums[i] < right[i + 1]) {
                sum += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                sum++;
            }
        }
        return sum;
    }
}
