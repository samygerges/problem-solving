package hackerrank;
import java.util.HashMap;
import java.util.Map;

public class HappyLadybugs {
	public static void main(String[] args) {
		System.out.println(happyLadybugs("AABCBC"));
	}

	static String happyLadybugs(String b) {
		Map<Character, Integer> map = new HashMap<>();
		int underscores = 0;
		for (char c : b.toCharArray()) {
			if (c != '_') {
				map.put(c, map.getOrDefault(c, 0) + 1);
			} else {
				underscores++;
			}
		}
		for (int i : map.values()) {
			if (i == 1)
				return "NO";
		}

		if (underscores == 0) {
			for (int i = 1; i < b.length() - 1; i++) {
				if (b.charAt(i) != b.charAt(i + 1) && b.charAt(i - 1) != b.charAt(i)) {
					return "NO";
				}
			}
		}

		return "YES";
	}

}
