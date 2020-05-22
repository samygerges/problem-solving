package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SequenceEquation {

	public static void main(String[] args) {
		int[] arr = permutationEquation(new int[] { 4, 3, 5, 1, 2 });
		for (int i : arr) {
			System.out.println(i);
		}
	}

	static int[] permutationEquation(int[] p) {
		int[] res = new int[p.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < p.length; i++) {
			map.put(p[i], i + 1);
		}
		for (int i = 0; i < p.length; i++) {
			res[i] = map.get(map.get(i + 1));
		}
		return res;
	}
}
