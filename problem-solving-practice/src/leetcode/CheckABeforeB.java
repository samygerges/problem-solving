package leetcode;

public class CheckABeforeB {
    public boolean checkString(String s) {
        int a = -1;
        int b = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a = i;
            }
            if (b != -1 && a > b) {
                return false;
            }
            if (s.charAt(i) == 'b') {
                b = i;
            }
        }

        return a <= b || (a > b && b == -1);
    }
}
