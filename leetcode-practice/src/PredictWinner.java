
public class PredictWinner {
	public boolean PredictTheWinner(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;

		return predict(nums, 0, 0, 0, nums.length - 1);
	}

	private boolean predict(int[] nums, int sum1, int sum2, int st, int end) {
		if (st == end) {
			return sum1 > sum2;
		}

		boolean a1 = false, a2 = false, a3 = false, a4 = false;

		a1 = predict(nums, sum1 + nums[st], sum2 + nums[end], st + 1, end - 1);
		if (st + 1 < nums.length)
			a2 = predict(nums, sum1 + nums[st], sum2 + nums[st + 1], st + 2, end);
		a3 = predict(nums, sum1 + nums[end], sum2 + nums[st], st + 1, end - 1);
		if (end - 1 >= 0)
			a4 = predict(nums, sum1 + nums[end], sum2 + nums[end - 1], st, end - 2);
		return a1 || a2 || a3 || a4;
	}

	public static void main(String[] args) {
		PredictWinner a = new PredictWinner();
		System.out.println(a.PredictTheWinner(new int[] { 1, 5, 2 }));
	}
}
