package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class GradingStudents {
	public static List<Integer> gradingStudents(List<Integer> grades) {
		List<Integer> res = new ArrayList<>();
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 40; i <= 100; i += 5) {
			set.add(i);
		}
		for (int i = 0; i < grades.size(); i++) {
			if (grades.get(i) < 38) {
				res.add(grades.get(i));
			} else {
				Integer y = set.higher(grades.get(i));
				if (y != null && y - grades.get(i) < 3) {
					res.add(y);
				} else {
					res.add(grades.get(i));
				}
			}
		}
		return res;
	}
}
