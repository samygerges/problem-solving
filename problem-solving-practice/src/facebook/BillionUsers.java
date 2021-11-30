package facebook;

public class BillionUsers {
    int getBillionUsersDay(float[] growthRates) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        long million = 1_000_000_000;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            double total = 0;
            for (float i : growthRates) {
                total += Math.pow(i, mid);
            }
            if(total > million) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(new BillionUsers().getBillionUsersDay(new float[]{1.5f}));
    }
}
