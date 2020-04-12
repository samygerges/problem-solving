import java.util.ArrayList;
import java.util.HashSet;

public class T9 {

	private static char[][] t9Letters = { null, null, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
			{ 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public static ArrayList<String> getValidT9Words(String number, HashSet<String> wordList) {
		ArrayList<String> res = new ArrayList<>();
		getValidWords(number, 0, "", wordList, res);
		return res;
	}

	private static void getValidWords(String number, int index, String prefix, HashSet<String> wordList,
			ArrayList<String> res) {
		if (index == number.length()) {
			if (wordList.contains(prefix))
				res.add(prefix);
			return;
		}

		char digit = number.charAt(index);
		char[] letters = getT6Chars(digit);

		if (letters != null) {
			for (char letter : letters) {
				getValidWords(number, index + 1, prefix + letter, wordList, res);
			}
		}

	}

	private static char[] getT6Chars(char digit) {
		if (!Character.isDigit(digit))
			return null;
		return t9Letters[Integer.parseInt("" + digit)];
	}

	public static void main(String[] args) {
		HashSet<String> words = new HashSet<>();
		words.add("tree");
		words.add("samy");
		words.add("used");
		System.out.println(getValidT9Words("8733", words));
	}
}
