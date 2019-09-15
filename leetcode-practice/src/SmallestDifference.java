import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SmallestDifference {

	public static int findSmallestDifference(int[] arr1, int[] arr2) {
		if (arr1 == null && arr2 == null)
			return 0;
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int diff = Integer.MAX_VALUE;
		int a = 0, b = 0;
		while (a < arr1.length && b < arr2.length) {
			if (Math.abs(arr1[a] - arr2[b]) < diff) {
				diff = Math.abs(arr1[a] - arr2[b]);
			}
			if (arr1[a] < arr2[b])
				a++;
			else
				b++;
		}
		return diff;
	}

	public static void main(String[] args) {
		System.out.println(findSmallestDifference(new int[] { 1, 3, 15, 11, 2 }, new int[] { 23, 127, 235, 19, 8 }));
		Map<Integer, String> map = new HashMap<>();
		map.putIfAbsent(1, "");
		map.getOrDefault(4,"");
		
		Queue<Integer> queue = new LinkedList<>();
		System.out.println(map.getOrDefault(map.get(0), "Samy"));		
	}

}
