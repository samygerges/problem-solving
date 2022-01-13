package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> middle = new HashMap<>();
        Map<String, Integer> boundary = new HashMap<>();

        for (String s : words) {
            if (s.charAt(0) == s.charAt(1)) {
                middle.put(s, middle.getOrDefault(s, 0) + 1);
            } else {
                boundary.put(s, boundary.getOrDefault(s, 0) + 1);
            }
        }
        int len = 0;
        boolean hasOne = false;
        for (String s : middle.keySet()) {
            if (middle.get(s) % 2 == 0) {
                len += middle.get(s) * 2;
            } else if (middle.get(s) > 1) {
                len += (middle.get(s) - 1) * 2;
                hasOne = true;
            } else {
                hasOne = true;
            }
        }
        if (hasOne) {
            len += 2;
        }
        for (String s : boundary.keySet()) {
            String s2 = "" + s.charAt(1) + s.charAt(0);
            if (boundary.containsKey(s2)) {
                int l = Math.min(boundary.get(s), boundary.get(s2));
                len += l * 2;
            }
        }
        return len;
    }
}
