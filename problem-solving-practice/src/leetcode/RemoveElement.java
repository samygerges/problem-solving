package leetcode;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0)
			return 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == val) {
				moveToEnd(nums, i);
				len--;
				i--;
			}
		}
		return nums.length - (nums.length - len);
	}

	private void moveToEnd(int[] nums, int index) {
		for (int i = index; i < nums.length - 1; i++) {
			int tmp = nums[i];
			nums[i] = nums[i + 1];
			nums[i + 1] = tmp;
		}
	}

	public static void main(String[] args) {
		RemoveElement a = new RemoveElement();
		System.out.println(a.removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
	}

}
