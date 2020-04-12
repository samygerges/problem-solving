import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ReorderLogFiles {

	public String[] reorderLogFiles(String[] logs) {
		ArrayList<String> alphanumeric = new ArrayList<>();
		ArrayList<String> normal = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < logs.length; i++) {
			String[] str = logs[i].split(" ");
			if (Character.isDigit(str[1].charAt(0))) {
				alphanumeric.add(logs[i]);
			} else {
				String s = "";
				for (int j = 1; j < str.length - 1; j++) {
					s += str[j] + " ";
				}
				s += str[str.length - 1];
				map.put(s, str[0]);
				normal.add(s);
			}
		}
		String[] res = new String[logs.length];
		Collections.sort(normal);
		for (int i = 0; i < normal.size(); i++) {
			res[i] = map.get(normal.get(i)) + " " + normal.get(i);
		}
		for (int i = 0; i < alphanumeric.size(); i++) {
			res[i + normal.size()] = alphanumeric.get(i);
		}

		return res;
	}

	public static void main(String[] args) {
		ReorderLogFiles a = new ReorderLogFiles();
		System.out.println(a.reorderLogFiles(
				new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" }));
	}
}
