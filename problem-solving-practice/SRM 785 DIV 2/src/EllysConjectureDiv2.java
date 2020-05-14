public class EllysConjectureDiv2 {

    public long getSum(int L, int R) {
        long sum = 0;
        long left = (L - 1) / 3;
        long right = R / 3;

        sum += (right - left) * 6;
        sum += (R - L + 1 - right + left) * 4;
        return sum;
    }
}
