import java.util.LinkedList;
import java.util.Queue;

public class Chapter1 {

	private String replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index;
		for (int i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		System.out.println(index);
		if (trueLength < str.length)
			str[trueLength] = '\0';

		for (int i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
		return new String(str);
	}

	private String stringCompression(String str) {
		Queue<Integer> queue = new LinkedList<>();
		
		int count = 1;
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			if (i + 1 < str.length()) {
				if (str.charAt(i) == str.charAt(i + 1))
					count++;
				else {
					result.append(str.charAt(i)).append(count);
					count = 1;
				}
			} else {
				result.append(str.charAt(i)).append(count);
				count = 1;
			}
		}
		return str.length() > result.length() ? result.toString() : str;
	}

	private boolean rotation(String str1, String str2) {
		StringBuilder tmp = new StringBuilder(str1);
		for (int i = 0; i < str1.length(); i++) {
			tmp = new StringBuilder(tmp.substring(i, tmp.length())).append(str1.charAt(i));
			if (tmp.toString().equals(str2))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Chapter1 c = new Chapter1();
		// System.out.println(c.replaceSpaces("Mr John Smith ".toCharArray(), 13));
		// System.out.println(c.stringCompression("aaaaaabcdd"));
		System.out.println(c.rotation("waterbottle", "erbottlewat"));
	}
}
