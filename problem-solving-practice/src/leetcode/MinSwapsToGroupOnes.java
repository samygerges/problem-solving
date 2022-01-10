package leetcode;

public class MinSwapsToGroupOnes {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for (int i : nums) {
            ones += i == 1 ? 1 : 0;
        }

        int[] num2 = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            num2[i] = nums[i % n];
        }

        int countOnesInWindow = 0;
        int maxOnesInWindow = 0;
        for (int i = 0; i < n * 2; i++) {
            if (i >= ones && num2[i - ones] == 1) {
                countOnesInWindow--;
            }
            if (num2[i] == 1) {
                countOnesInWindow++;
            }
            maxOnesInWindow = Math.max(maxOnesInWindow, countOnesInWindow);
        }

        return ones - maxOnesInWindow;
    }
}
