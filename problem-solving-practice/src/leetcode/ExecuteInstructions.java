package leetcode;

public class ExecuteInstructions {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            int x = startPos[0];
            int y = startPos[1];
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'R') {
                    y += 1;
                } else if (s.charAt(j) == 'L') {
                    y -= 1;
                } else if (s.charAt(j) == 'U') {
                    x -= 1;
                } else if (s.charAt(j) == 'D') {
                    x += 1;
                }
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    count++;
                } else {
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
