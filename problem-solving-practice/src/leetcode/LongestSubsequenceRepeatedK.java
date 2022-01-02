package leetcode;

import java.util.ArrayDeque;

public class LongestSubsequenceRepeatedK {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        String answer = "";
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(answer);
        while (!queue.isEmpty()) {
            String candidate = queue.poll();
            for (int i = 0; i < 26; i++) {
                if (freq[i] >= k && isKSub(s, candidate + (char) ('a' + i), k)) {
                    answer = candidate + (char) ('a' + i);
                    queue.add(answer);
                }
            }
        }

        return answer;
    }

    private boolean isKSub(String s, String sub, int k) {
        int j = 0;
        int count = 0;
        boolean isSub = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
                if (j == sub.length()) {
                    count++;
                    j = 0;
                }
                if (count == k) {
                    isSub = true;
                    break;
                }
            }
        }
        return isSub;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubsequenceRepeatedK().longestSubsequenceRepeatedK("letsleetcode", 2));
    }
}
