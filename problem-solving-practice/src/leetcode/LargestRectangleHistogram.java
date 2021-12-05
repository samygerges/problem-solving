package leetcode;

import java.util.ArrayDeque;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = getSmallerPositionsLeft(heights);
        int[] right = getSmallerPositionsRight(heights);

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    private int[] getSmallerPositionsLeft(int[] arr) {
        int n = arr.length;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] smaller = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= stack.peek()[0]) {
                stack.pop();
            }
            smaller[i] = stack.isEmpty() ? -1 : stack.peek()[1];
            stack.push(new int[]{arr[i], i});
        }

        return smaller;
    }

    private int[] getSmallerPositionsRight(int[] arr) {
        int n = arr.length;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] smaller = new int[n];
        for (int i = n - 1; i > -1; i--) {
            while (!stack.isEmpty() && arr[i] <= stack.peek()[0]) {
                stack.pop();
            }
            smaller[i] = stack.isEmpty() ? n : stack.peek()[1];
            stack.push(new int[]{arr[i], i});
        }

        return smaller;
    }
}
