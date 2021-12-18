package leetcode;

import java.util.Arrays;

public class SortedSquares {

    public int[] sortedSquares(int[] a) {
        int[] answer = new int[a.length];
        int i = 0;
        int j = a.length - 1;
        int k = a.length - 1;
        while(i <= j) {
            if(a[i] * a[i] > a[j] * a[j]) {
                answer[k--] = a[i] * a[i];
                i++;
            } else {
                answer[k--] = a[j] * a[j];
                j--;
            }
        }
        return answer;
    }

    public int[] sortedSquares2(int[] a) { // best answer above
        int[] answer = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            answer[i] = a[i] * a[i];
        }
        Arrays.sort(answer);
        return answer;
    }
}
