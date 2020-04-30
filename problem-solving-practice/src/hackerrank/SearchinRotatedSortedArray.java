package hackerrank;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(search(new int[] { 5, 1, 2, 3, 4 }, 4));
	}

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int left = 0;
		int right = nums.length - 1;
		return binarySearch(nums, left, right, target);
	}

	private static int binarySearch(int[] nums, int left, int right, int target) {
		int mid = (left + right) / 2;
		if (nums[mid] == target)
			return mid;
		if (left == right)
			return -1;
		int low = -1, high = -1;
		if (mid - 1 >= 0 && mid - 1 >= left) {
			low = binarySearch(nums, left, mid - 1, target);
		}
		if (mid + 1 < nums.length && mid + 1 <= right) {
			high = binarySearch(nums, mid + 1, right, target);
		}
		return low != -1 ? low : high != -1 ? high : -1;
	}
}
