package others;
import java.util.HashMap;
import java.util.Map;

public class GooglePhoneInterview {

	public static String score(char[] board, char[] guess) {
		if (board == null || guess == null)
			return null;
		if (board.length != guess.length)
			return null;
		boolean[] visit = new boolean[board.length];
		String score = "";

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < guess.length; i++) {
			if (guess[i] == board[i]) {
				visit[i] = true;
				score += "B";
			} else {
				map.putIfAbsent("" + board[i], 0);
				map.put("" + board[i], map.get("" + board[i]) + 1);
			}
		}

		for (int i = 0; i < guess.length; i++) {
			if (map.containsKey("" + guess[i]) && map.get("" + guess[i]) > 0) {
				score += "W";
				map.put("" + guess[i], map.get("" + guess[i]) - 1);
			}
		}
		return score;
	}

	public static void main(String[] args) {
		System.out.println(score("RGOO".toCharArray(), "RGOO".toCharArray()));
	}
}
