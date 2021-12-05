package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStrChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String s : words) {
            map.put(s, 1);
            for (int i = 0; i < s.length(); i++) {
                String prev = new StringBuilder(s).deleteCharAt(i).toString();
                if (map.containsKey(prev) && map.get(prev) + 1 > map.get(s)) {
                    map.put(s, map.get(prev) + 1);
                }
            }
            max = Math.max(max, map.get(s));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestStrChain().longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
    }
}
