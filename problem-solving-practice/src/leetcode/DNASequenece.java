package leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.util.Pair;

public class DNASequenece {

	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> list = new HashSet<>();
		for (int i = 0; i < s.length() - 10; i++) {
			String tmp = s.substring(i + 10, s.length());
			String dna = s.substring(i, i + 10);
			if (tmp.indexOf(dna) != -1)
				list.add(dna);
		}
		return new ArrayList<String>(list);
	}

	public static void main(String[] args) {
		Pair<Integer, Integer> pair = new Pair<>(5, 10);
		System.out.println(pair.getKey());
		System.out.println(pair.getValue());
		
		DNASequenece a = new DNASequenece();
		System.out.println(a.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
}
