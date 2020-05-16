package leetcode;

import java.util.Collections;
import java.util.List;

public class ReplaceWords {

	public String replaceWords(List<String> dict, String sentence) {
		StringBuilder sb = new StringBuilder();

		Collections.sort(dict);
		String[] arr = sentence.split(" ");
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			boolean added = false;
			for (String root : dict) {
				if (s.startsWith(root)) {
					sb.append(root);
					added = true;
					break;
				}
			}
			if (!added) {
				sb.append(s);
			}
			if (i + 1 < arr.length) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}
}
