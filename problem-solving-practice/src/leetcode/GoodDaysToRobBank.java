package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GoodDaysToRobBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] nonIncreasing = new int[n];
        int[] nonDecreasing = new int[n];

        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                nonIncreasing[i] = nonIncreasing[i - 1] + 1;
            }
        }
        for (int i = n - 2; i > -1; i--) {
            if (security[i] <= security[i + 1]) {
                nonDecreasing[i] = nonDecreasing[i + 1] + 1;
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (nonIncreasing[i] >= time && nonDecreasing[i] >= time) {
                answer.add(i);
            }
        }
        return answer;
    }
}
