package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfBeams {
    public int numberOfBeams(String[] bank) {
        int answer = 0;
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < bank.length; i++) {
            int row = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    row++;
                }
            }
            if (row > 0) {
                rows.add(row);
            }
        }
        for (int i = 1; i < rows.size(); i++) {
            answer += rows.get(i) * rows.get(i - 1);
        }
        return answer;
    }
}
