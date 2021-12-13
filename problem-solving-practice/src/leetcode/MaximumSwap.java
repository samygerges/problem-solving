package leetcode;

public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] str = String.valueOf(num).toCharArray();
        for(int i = 0; i < str.length; i++) {
            boolean canSwap = false;
            char min = str[i];
            int index = i;
            for(int j = i + 1; j < str.length; j++) {
                if(min <= str[j]) {
                    min = str[j];
                    index = j;
                    canSwap = true;
                }
            }
            if(canSwap && i != index && str[i] != str[index]) {
                char tmp = str[i];
                str[i] = str[index];
                str[index] = tmp;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(str));
    }
}
