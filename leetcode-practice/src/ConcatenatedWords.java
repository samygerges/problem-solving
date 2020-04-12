
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConcatenatedWords {
	public static void main(String[] args) {
		ConcatenatedWords c = new ConcatenatedWords();
		System.out.println(c.findAllConcatenatedWordsInADict(new String[] { "cat", "cats", "catsdogcats", "dog",
				"dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" }));
	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Set<String> dictionary = new HashSet<>(Arrays.asList(words));
		Map<String, Boolean> cache = new HashMap<>();
		List<String> result = new ArrayList<>();
		for (String word : words) {
			if (canForm(word, dictionary, cache)) {
				result.add(word);
			}
		}
		return result;
	}

	private boolean canForm(String word, Set<String> dictionary, Map<String, Boolean> cache) {
		if (cache.containsKey(word)) {
			return cache.get(word);
		}
		for (int i = 1; i < word.length(); i++) {
			String prefix = word.substring(0, i);
			String suffix = word.substring(i);
			if (dictionary.contains(prefix)) {
				if (dictionary.contains(suffix) || canForm(suffix, dictionary, cache)) {
					cache.put(word, true);
					return true;
				}
			}
		}
		cache.put(word, false);
		return false;
	}
}
