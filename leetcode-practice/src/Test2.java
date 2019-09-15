import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * For a given vector of integers and integer K, find the number of non-empty
 * subsets S such that min(S) + max(S) <= K For example, for K = 8 and vector
 * [2, 4, 5, 7], the solution is 5 ([2], [4], [2, 4], [2, 4, 5], [2, 5]) The
 * time complexity should be O(n2). Approach and code was asked
 *
 */

public class Test2 {

	public static int findKthLargest(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], 0);
			map.put(nums[i], map.get(nums[i]) + 1);
		}

		int resultIndex = nums.length - k;
		int count = 0;

		for (Integer i : map.keySet()) {
			Integer num = map.get(i);
			if (num + count >= resultIndex)
				return i;
			count += num;
		}
		return -1;
	}

	public static int getNumOfSubsets(int[] arr, int k) {
		if (arr == null || arr.length == 0)
			return 0;
		return getNumOfSubsets(arr, 0, 1, new ArrayList<Integer>(), k);
	}

	private static int getNumOfSubsets(int[] arr, int index, int size, ArrayList<Integer> tmp, int k) {
		if (size == tmp.size()) {
			int sum = getSumMinMax(tmp);
			if (sum <= k)
				return 1;
			else
				return 0;
		}
		int sum = 0;
		for (int i = index; i < arr.length; i++) {
			for (int j = size; j <= arr.length; j++) {
				tmp.add(arr[i]);
				sum += getNumOfSubsets(arr, index + 1, j, tmp, k);
				if (i < tmp.size())
					tmp.remove(i);
			}
		}
		return sum;
	}

	private static int getSumMinMax(List<Integer> arr) {
		if (arr == null || arr.size() == 0)
			return 0;
		return arr.get(0) + arr.get(arr.size() - 1);
	}

	private static Set<String> pd = new HashSet<String>();

	public static String longestPalindrome(String s) {
		if (s == null)
			return "";
		if (isPalindrome(s)) {
			pd.add(s);
			return s;
		}

		if (pd.contains(s))
			return s;

		String str1 = longestPalindrome(s.substring(0, s.length() - 1));
		String str2 = longestPalindrome(s.substring(1, s.length()));

		if (isPalindrome(str1) && str1.length() > str2.length()) {
			pd.add(str1);
			return str1;
		} else if (isPalindrome(str2)) {
			pd.add(str2);
			return str2;
		}

		return "";
	}

	private static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}

	public static int countSubstrings(String s) {
		// return countSubstrings(s, 1);
		int count = 0;

		for (int j = 0; j < s.length(); j++) {
			for (int i = j + 1; i <= s.length(); i++) {
				System.out.println(s.substring(j, i));
				if (isPalindrome(s.substring(j, i))) {
					count++;
				}
			}
		}

		return count;
	}

	private static int countSubstrings(String s, int length) {
		if (s.length() == length) {
			System.out.println(s);
			if (isPalindrome(s))
				return 1;
			return 0;
		}

		int count = 0;

		for (int j = 0; j < s.length(); j++) {
			for (int i = j + 1; i < s.length(); i++) {
				count += countSubstrings(s.substring(j, i), j + 1);
			}
		}

		return count;
	}

	public static int minPathSum(int[][] grid) {
		// boolean[][] visit = new boolean[grid.length][grid[0].length];
		// return minPathSum(grid, 0, 0, visit);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (i - 1 >= 0 && j - 1 >= 0)
					grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
				else if (j - 1 >= 0) {
					grid[i][j] = grid[i][j] + grid[i][j - 1];
				} else if (i - 1 >= 0)
					grid[i][j] = grid[i][j] + grid[i - 1][j];
			}
		}

		return grid[grid.length - 1][grid[0].length - 1];
	}

	public static int minPathSum(int[][] grid, int row, int col, boolean[][] visit) {

		if (row == grid.length - 1 && col == grid[row].length - 1)
			return grid[row][col];
		int sum = Integer.MAX_VALUE;
		for (int i = row; i < grid.length; i++) {
			for (int j = col; j < grid[col].length; j++) {
				visit[i][j] = true;
				if (i + 1 < grid.length && !visit[i + 1][j]) {
					int sum1 = grid[i][j] + minPathSum(grid, i + 1, j, visit);
					sum = Math.min(sum, sum1);
				}
				if (j + 1 < grid[i].length && !visit[i][j + 1]) {
					int sum2 = grid[i][j] + minPathSum(grid, i, j + 1, visit);
					sum = Math.min(sum, sum2);
				}
				visit[i][j] = false;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		// System.out.println(getNumOfSubsets(new int[] { 2, 4, 5, 7 }, 8));
		// System.out.println(longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
		// System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		// System.out.println(countSubstrings("aaa"));
		System.out.println(minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
	}

}
