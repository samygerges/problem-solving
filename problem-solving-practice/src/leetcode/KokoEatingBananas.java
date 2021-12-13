package leetcode;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1;
        int high = piles[piles.length - 1];

        int answer = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int countHours = 0;
            for (int i : piles) {
                if (i <= mid) {
                    countHours++;
                } else {
                    if (i % mid == 0) {
                        countHours += i / mid;
                    } else {
                        countHours += (i / mid) + 1;
                    }
                }
            }
            if (h - countHours >= 0) {
                answer = Math.min(answer, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}
