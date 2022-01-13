package leetcode;

public class CapitalizeTitle {
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        String[] str = title.split(" ");
        for (int i = 0; i < str.length; i++) {
            char[] arr = str[i].toLowerCase().toCharArray();
            if (arr.length > 2) {
                arr[0] = Character.toUpperCase(arr[0]);
            }
            sb.append(arr);
            if(i + 1 < str.length) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
