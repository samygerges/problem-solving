package leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);

        int diff = Math.abs(a.length() - b.length());
        if (a.length() < b.length()) {
            while (diff > 0) {
                sa.insert(0, 0);
                diff--;
            }
        }
        if (b.length() < a.length()) {
            while (diff > 0) {
                sb.insert(0, 0);
                diff--;
            }
        }

        int i = sa.length() - 1;
        int carry = 0;
        while (i >= 0) {
            if (sa.charAt(i) == '1' && sb.charAt(i) == '1') {
                if (carry == 1) {
                    res.insert(0, 1);
                } else {
                    res.insert(0, 0);
                    carry = 1;
                }
            } else if (sa.charAt(i) == '0' && sb.charAt(i) == '0') {
                if (carry == 1) {
                    res.insert(0, 1);
                    carry = 0;
                } else {
                    res.insert(0, 0);
                }
            } else {
                if (carry == 1) {
                    res.insert(0, 0);
                } else {
                    res.insert(0, 1);
                    carry = 0;
                }
            }

            i--;
        }
        if (carry == 1) {
            res.insert(0, 1);
        }
        return res.toString();
    }
}
