package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntervalsBetweenIdenticalElements {

    public long[] getDistances(int[] arr) {
        long[] output = new long[arr.length];
        Map<Integer, Long> sumMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            if (!sumMap.containsKey(arr[i])) {
                sumMap.put(arr[i], 0l);
                countMap.put(arr[i], 0);
            }

            output[i] += i * (long) countMap.get(arr[i]) - sumMap.get(arr[i]);
            sumMap.put(arr[i], sumMap.get(arr[i]) + i);
            countMap.put(arr[i], countMap.get(arr[i]) + 1);
        }

        sumMap = new HashMap<>();
        countMap = new HashMap<>();
        int len = arr.length;
        for (int i = len - 1; i >= 0; --i) {
            if (!sumMap.containsKey(arr[i])) {
                sumMap.put(arr[i], 0l);
                countMap.put(arr[i], 0);
            }

            output[i] += (len - i - 1) * (long) countMap.get(arr[i]) - sumMap.get(arr[i]);
            sumMap.put(arr[i], sumMap.get(arr[i]) + (len - i - 1));
            countMap.put(arr[i], countMap.get(arr[i]) + 1);
        }

        return output;
    }

    public long[] getDistancesTLE(int[] arr) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new HashSet<>());
            map.get(arr[i]).add(i);
        }

        long[] answer = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j : map.get(arr[i])) {
                sum += Math.abs(i - j);
            }
            answer[i] = sum;
        }

        return answer;
    }
}
