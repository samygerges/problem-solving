import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	private boolean visit[][];

	private int globalMax = 0;

	public int getMaxColorCount(int[][] arr) {
		visit = new boolean[arr.length][arr[0].length];
		for (int r = 0; r < arr.length; r++) {
			for (int s = 0; s < arr[0].length; s++) {
				if (!visit[r][s]) {
					visitArray(arr, arr[r][s], r, s, 1);
				}
			}
		}
		return globalMax;
	}

	private void visitArray(int[][] arr, int currentColor, int i, int j, int count) {
		if (count > globalMax) {
			globalMax = count;
		}

		visit[i][j] = true;
		List<Integer[]> neighbours = getNeigbours(arr, currentColor, i, j);
		for (int k = 0; k < neighbours.size(); k++) {
			visitArray(arr, currentColor, neighbours.get(k)[0], neighbours.get(k)[1], ++count);
		}
	}

	private List<Integer[]> getNeigbours(int[][] arr, int currentColor, int i, int j) {
		List<Integer[]> result = new ArrayList<>();
		if (i + 1 < arr.length && !visit[i + 1][j] && arr[i + 1][j] == currentColor) {
			Integer[] neigbour = new Integer[2];
			neigbour[0] = i + 1;
			neigbour[1] = j;
			result.add(neigbour);
		}
		if (i - 1 > 0 && !visit[i - 1][j] && arr[i - 1][j] == currentColor) {
			Integer[] neigbour = new Integer[2];
			neigbour[0] = i - 1;
			neigbour[1] = j;
			result.add(neigbour);
		}
		if (j + 1 < arr[0].length && !visit[i][j + 1] && arr[i][j + 1] == currentColor) {
			Integer[] neigbour = new Integer[2];
			neigbour[0] = i;
			neigbour[1] = j + 1;
			result.add(neigbour);
		}
		if (j - 1 > 0 && !visit[i][j - 1] && arr[i][j - 1] == currentColor) {
			Integer[] neigbour = new Integer[2];
			neigbour[0] = i;
			neigbour[1] = j - 1;
			result.add(neigbour);
		}
		return result;
	}

	public static List<Integer> countSmaller(int[] nums) {
		Integer[] res = new Integer[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] < nums[j])
					count++;
			}
			res[i] = count;
		}

		return Arrays.asList(res);
	}

	public static void main(String[] args) {
		Test tes = new Test();
		// System.out.println(tes.getMaxColorCount(new int[][] { { 1, 0, 0, 2 }, { 0, 1,
		// 2, 1 } }));
		//System.out.println(countSmaller(new int[] { 5, 2, 6, 1 }));
		HashSet<Integer> set = new HashSet<>();
	}

}
