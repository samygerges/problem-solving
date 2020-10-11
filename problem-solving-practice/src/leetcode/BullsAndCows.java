package leetcode;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows
{
	public String getHint(String secret, String guess) {
		int n = secret.length();
		boolean[] visited = new boolean[n];
		Map<Character, Integer> map = new HashMap<>();
		int a = 0;
		int b = 0;
		for(int i = 0; i < n; i++) {
			if(secret.charAt(i) == guess.charAt(i)) {
				visited[i] = true;
				a++;
			} else {
				map.putIfAbsent(secret.charAt(i), 0);
				map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
			}
		}
		for(int i = 0; i < n; i++) {
			if(visited[i]) {
				continue;
			}
			else {
				if(map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0) {
					b++;
					map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
				}
			}
		}

		return a + "A" + b + "B";
	}
}
