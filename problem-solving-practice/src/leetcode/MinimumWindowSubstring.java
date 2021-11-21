package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : t.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        String ans = "";
        int minLength = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        while (l < s.length()) {
            Map<Character, Integer> current = new HashMap<>(counts);
            Map<Character, Integer> currentCount = new HashMap<>();
            while (r < s.length()) {
                if (counts.containsKey(s.charAt(r))) {
                    currentCount.put(s.charAt(r), currentCount.getOrDefault(s.charAt(r), 0) + 1);
                    if (current.containsKey(s.charAt(r))) {
                        current.put(s.charAt(r), current.get(s.charAt(r)) - 1);
                        if (current.get(s.charAt(r)) == 0) {
                            current.remove(s.charAt(r));
                        }
                    }
                }
                if (current.size() == 0) break;
                r++;
            }
            if (current.size() == 0) {
                while (l <= r) {
                    if (counts.containsKey(s.charAt(l))) {
                        if (currentCount.get(s.charAt(l)) > counts.get(s.charAt(l))) {
                            currentCount.put(s.charAt(l), currentCount.get(s.charAt(l)) - 1);
                        } else {
                            if (minLength > r - l + 1) {
                                minLength = r - l + 1;
                                ans = s.substring(l, r + 1);
                            }
                            break;
                        }
                    }
                    l++;
                }
            }
            l++;
            r = l;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("bdab", "ab"));
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }
}
