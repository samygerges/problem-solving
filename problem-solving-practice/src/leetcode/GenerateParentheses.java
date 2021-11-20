package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        generateAll(n,"", set, 0, 0);
        List<String> res = new ArrayList<>(set);
        return res;
    }

    private void generateAll(int n, String sb, Set<String> all, int left, int right) {
        if (left == right && right == n) {
            all.add(sb);
            return;
        }

        if (left != n) {
            generateAll(n,sb + "(", all, left + 1, right);
        }
        if (left > right) {
            generateAll(n,sb + ")", all, left, right + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
