package leetcode;

import java.math.BigInteger;

public class AbbreviateProduct {

    public String abbreviateProduct(int left, int right) {
        double a = 1L; // for first 5 digits
        long b = 1L; // for last 5 digits
        long c = 1L; // for small result
        int zn = 0; // zero count
        for (int i = left; i <= right; i++) {
            a *= i;
            b *= i;
            while (b % 10 == 0) {
                b /= 10;
                zn++;
            }
            if (a > 1000000000000L) a /= 1000000;
            if (b > 1000000000000L) b %= 1000000;
            if (c < 10000000000L) c *= i;
            while (c % 10 == 0) c /= 10;
        }
        if (c < 10000000000L) return c + "e" + zn;
        String astr = String.valueOf(a).replace(".", "");
        String bstr = String.valueOf(b);
        while (bstr.length() < 5) bstr = "0" + bstr;
        return astr.substring(0, 5) + "..." + bstr.substring(bstr.length() - 5) + "e" + zn;
    }

    public String abbreviateProductTLE(int left, int right) {
        BigInteger product = BigInteger.ONE;
        for (long i = left; i <= right; i++) {
            product = product.multiply(BigInteger.valueOf(i));
        }

        String s = product.toString();
        int count = 0;
        int start = s.length() - 1;
        for (start = s.length() - 1; start > -1; start--) {
            if (s.charAt(start) == '0') {
                count++;
            } else {
                break;
            }
        }
        s = s.substring(0, start + 1);
        StringBuilder sb = new StringBuilder();
        if (s.length() > 10) {
            sb.append(s.substring(0, 5)).append("...").append(s.substring(s.length() - 5));
        } else {
            sb.append(s);
        }
        sb.append('e').append(count);

        return sb.toString();
    }
}
