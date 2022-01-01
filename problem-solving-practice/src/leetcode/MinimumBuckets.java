package leetcode;

public class MinimumBuckets {
    public int minimumBuckets(String street) {
        char[] arr = street.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'H' && ((i + 1 < arr.length && arr[i + 1] == 'B') || (i - 1 >= 0 && arr[i - 1] == 'B'))) {
                continue;
            }
            if (arr[i] == 'H' && i + 1 < arr.length && arr[i + 1] == '.') {
                arr[i + 1] = 'B';
            } else if (arr[i] == 'H' && i - 1 >= 0 && arr[i - 1] == '.') {
                arr[i - 1] = 'B';
            } else if (arr[i] == '.' || arr[i] == 'B') {
                continue;
            } else {
                return -1;
            }
            count++;
        }
        return count;
    }
}
