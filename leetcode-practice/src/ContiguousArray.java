import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	public static void main(String[] args) {
		ContiguousArray c = new ContiguousArray();
		System.out.println(c.findMaxLength(new int[] { 0, 1, 0, 1 }));
		System.out.println(c.findMaxLength(new int[] { 0, 0, 0, 1, 1, 1, 0 }));
		System.out.println(c.findMaxLength(new int[] { 0, 0, 1, 0, 0, 0, 1, 1 }));
	}

	public int findMaxLength(int[] nums) {
		int max = 0, count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count--;
			} else {
				count++;
			}
			if (map.containsKey(count)) {
				max = Math.max(max, i - map.get(count));
			} else {
				map.put(count, i);
			}
		}
		return max;
	}
}
