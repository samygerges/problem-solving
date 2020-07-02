package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class FullCountingSort {
	static void countSort(List<List<String>> arr) {
		List<StringBuilder> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(new StringBuilder());
		}
		for (int i = 0; i < arr.size(); i++) {
			int x = Integer.parseInt(arr.get(i).get(0));
			if (i < arr.size() / 2) {
				list.get(x).append("-").append(" ");
			} else {
				list.get(x).append(arr.get(i).get(1)).append(" ");
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			if (list.get(i).length() > 0) {
				sb.append(list.get(i));
			}
		}
		System.out.println(sb.toString());
	}
}
