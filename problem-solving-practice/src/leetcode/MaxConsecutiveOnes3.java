package leetcode;

public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int flips = 0;
        int max = 0;
        while (left < nums.length && right < nums.length) {
            if (nums[right] == 1 || flips < k) {
                if (nums[right] == 0) {
                    flips++;
                }
                count++;
                right++;
                max = Math.max(count, max);
            } else {
                if (nums[left] == 0) {
                    flips--;
                }
                count--;
                left++;
            }
        }

        return max;
    }
}
