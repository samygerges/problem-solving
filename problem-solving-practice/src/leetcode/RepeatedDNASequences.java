package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> list = new HashSet<>();
		Set<String> answer = new HashSet<>();
		for (int i = 0; i < s.length() - 9; i++) {
			String dna = s.substring(i, i + 10);
			if (list.contains(dna)) {
				answer.add(dna);
			} else {
				list.add(dna);
			}
		}
		return new ArrayList<>(answer);
	}
}
