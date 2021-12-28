package leetcode;

public class ParenthesesStringCanBeValid {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) return false;
        int open = 0;
        int closed = 0;
        int canChange = 0;

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                canChange++;
            } else if (s.charAt(i) == '(') {
                open++;
            } else {
                closed++;
            }
            if (canChange + open - closed < 0) {
                return false;
            }
        }
        open = 0;
        closed = 0;
        canChange = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (locked.charAt(i) == '0') {
                canChange++;
            } else if (s.charAt(i) == '(') {
                open++;
            } else {
                closed++;
            }
            if (canChange - open + closed < 0) {
                return false;
            }
        }
        return true;
    }
}
