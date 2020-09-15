package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SubarraysWithKDistinct {

	public static void main(String[] args) {
		System.out.println(new SubarraysWithKDistinct().subarraysWithKDistinct(new int[] { 1, 2, 1, 3, 4 }, 3));
	}

	public int subarraysWithKDistinct(int[] A, int K) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = i; j < A.length; j++) {
				set.add(A[j]);
				if (set.size() == K) {
					count++;
				} else if(set.size() > K) {
                    break;
                }
			}
		}
		return count;
	}
}
