package facebook;

import java.util.ArrayList;
import java.util.List;

public class PermutationGenerator {

    public List<Integer> permutation(int n) {
        List<Integer> answer = new ArrayList<>();
        permutation(n, new StringBuilder(), answer, new boolean[n]);
        return answer;
    }

    private void permutation(int n, StringBuilder sb, List<Integer> answer, boolean[] visited) {
        if(sb.length() == n) {
            answer.add(Integer.parseInt(sb.toString()));
        }
        else {
            for(int i = 1; i <= n; i++) {
                if(!visited[i - 1]) {
                    visited[i - 1] = true;
                    sb.append(i);
                    permutation(n, sb, answer, visited);
                    sb.deleteCharAt(sb.length() - 1);
                    visited[i - 1] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationGenerator().permutation(4));
    }
}
