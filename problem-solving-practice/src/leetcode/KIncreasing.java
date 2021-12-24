package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KIncreasing {
    public int kIncreasing(int[] arr, int k) {
        int count = 0;

        for (int i = 0; i < k; i++) {
            List<Integer> subseq = new ArrayList<>();
            for (int j = i; j < arr.length; j += k) {
                subseq.add(arr[j]);
            }
            count += subseq.size() - longestNonDecreasingSeq(subseq);
        }

        return count;
    }

    private int longestNonDecreasingSeq(List<Integer> arr) {
        List<Integer> nonDecreasing = new ArrayList<>();
        for (Integer i : arr) {
            if (nonDecreasing.isEmpty() || nonDecreasing.get(nonDecreasing.size() - 1) <= i) {
                nonDecreasing.add(i);
            } else {
                int index = upperBound(nonDecreasing, i);
                nonDecreasing.set(index, i);
            }
        }
        return nonDecreasing.size();
    }

    private int upperBound(List<Integer> subseq, int num) {
        int left = 0;
        int right = subseq.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (num < subseq.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
