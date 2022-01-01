package leetcode;

public class MaxConsecutiveAnswers {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max = 0;
        int n = answerKey.length();
        int t = 0;
        int f = 0;
        int left = 0;
        int right = left;
        while (right < n) {
            int length = right - left + 1;
            if (answerKey.charAt(right) == 'T') {
                t++;
            } else {
                f++;
            }
            if (length - Math.max(t, f) <= k) {
                max = Math.max(max, length);
            } else {
                if (answerKey.charAt(left) == 'T') {
                    t--;
                } else {
                    f--;
                }
                left++;
            }
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveAnswers().maxConsecutiveAnswers("FFFTTFTTFT", 3));
    }
}
