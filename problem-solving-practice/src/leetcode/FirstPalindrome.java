package leetcode;

public class FirstPalindrome {
    public String firstPalindrome(String[] words) {
        String answer = "";
        for (String word : words) {
            if (isPalindrome(word)) {
                answer = word;
                break;
            }
        }
        return answer;
    }

    private boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
