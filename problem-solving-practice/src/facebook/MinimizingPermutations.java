package facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimizingPermutations {

    int minOperations(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
            index.put(arr[i], i);
        }
        int swaps = 0;
        int currentIndex = 0;
        while (!heap.isEmpty()) {
            int num = heap.poll();
            if (num < arr[currentIndex]) {
                reverse(arr, Math.min(index.get(num), currentIndex), Math.max(index.get(num), currentIndex), index);
                swaps++;
            }
            currentIndex++;
        }
        return swaps;
    }

    private void reverse(int[] arr, int start, int end, Map<Integer, Integer> index) {
        for (int i = start, j = end; i <= end && j > i; j--, i++) {
            swap(arr, i, j);
            index.put(arr[i], i);
            index.put(arr[j], j);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
