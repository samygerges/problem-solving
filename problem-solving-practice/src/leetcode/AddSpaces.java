package leetcode;

public class AddSpaces {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && spaces[j] == i) {
                j++;
                sb.append(" ");
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
