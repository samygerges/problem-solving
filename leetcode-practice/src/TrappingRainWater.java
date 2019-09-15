
public class TrappingRainWater {
	public int trap(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int count = 0;

		int left = 0;
		int right = 0;

		while (left < height.length) {
			while (left < height.length && height[left] == 0) {
				left++;
			}
			right = left + 1;
			boolean less = false;
			int min = 0;
			while (right < height.length) {
				if (height[right] < height[left] && !less) {
					less = true;
					min = height[right];
				}
				if (less && min < height[right])
					break;
				right++;
			}
			if (right >= height.length) {
				left++;
				continue;
			}
			if (left >= height.length)
				left = height.length - 1;
			if (right >= height.length)
				right = height.length - 1;
			count += getTrap(height, left, right);
			left = right;
		}
		return count;
	}

	private int getTrap(int[] arr, int left, int right) {
		int min = Math.min(arr[left], arr[right]);
		int count = 0;
		for (int i = left + 1; i < right; i++) {
			count += min - arr[i];
		}
		return count;
	}

	public static void main(String[] args) {
		TrappingRainWater a = new TrappingRainWater();
		System.out.println(a.trap(new int[] { 4, 2, 3 }));
		System.out.println(a.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}
}
