
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords
{
	public static void main(String[] args)
	{
		TopKFrequentWords t = new TopKFrequentWords();
		System.out.println(t.topKFrequent(new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));
	}

	public List<String> topKFrequent(String[] words, int k)
	{
		if (words == null || words.length == 0)
		{
			return Collections.emptyList();
		}
		if (k > words.length)
		{
			k = words.length;
		}
		Map<String, WordFrequency> map = new HashMap<>();
		for (String word : words)
		{
			WordFrequency wordFrequency = map.getOrDefault(word, new WordFrequency(word, 0));
			wordFrequency.frequency++;
			map.put(word, wordFrequency);
		}

		List<WordFrequency> list = new ArrayList<>(map.values());
		Collections.sort(list);

		List<String> result = new ArrayList<>();
		for (int i = 0; i < k; i++)
		{
			result.add(list.get(i).word);
		}
		return result;
	}

	class WordFrequency implements Comparable<WordFrequency>
	{
		String word;
		int frequency;

		WordFrequency(String word, int frequency)
		{
			this.word = word;
			this.frequency = frequency;
		}

		@Override
		public int compareTo(WordFrequency o)
		{
			if (frequency > o.frequency)
			{
				return -1;
			}
			if (frequency < o.frequency)
			{
				return 1;
			}
			return word.compareTo(o.word);
		}
	}
}
