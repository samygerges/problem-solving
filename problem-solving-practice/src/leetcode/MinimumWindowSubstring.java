package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int minimum = Integer.MAX_VALUE;
        String res = "";
        Map<Character, Integer> currentMap = new HashMap<>();
        while (left < s.length()) {
            while (right < s.length()) {
                currentMap.put(s.charAt(right), currentMap.getOrDefault(s.charAt(right), 0) + 1);
                right++;
                if (match(currentMap, map)) {
                    break;
                }
            }
            while (left < right - 1 && (!map.containsKey(s.charAt(left)) || currentMap.get(s.charAt(left)) > map.getOrDefault(s.charAt(left), 0))) {
                currentMap.put(s.charAt(left), currentMap.get(s.charAt(left)) - 1);
                left++;
            }
            if (match(currentMap, map)) {
                if (minimum > right - left) {
                    minimum = right - left;
                    res = s.substring(left, right);
                }
            }
            currentMap.put(s.charAt(left), currentMap.get(s.charAt(left)) - 1);
            left++;
        }

        return res;
    }

    private boolean match(Map<Character, Integer> substring, Map<Character, Integer> t) {
        for (char c : t.keySet()) {
            if (!substring.containsKey(c) || substring.get(c) < t.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("abc", "b"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "a"));
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }
}
