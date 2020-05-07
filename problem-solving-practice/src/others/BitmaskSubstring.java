package others;

import java.util.ArrayList;
import java.util.List;

public class BitmaskSubstring {

	public static void main(String[] args) {
		System.out.println(substring("abc"));
	}

	public static List<String> substring(String s) {
		List<String> all = new ArrayList<>();

		for (int i = 0; i < Math.pow(2, s.length()); i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {
				if ((i & (1 << j)) > 0) {
					sb.append(s.charAt(j));
				}
			}
			all.add(sb.toString());
		}
		return all;
	}

}
