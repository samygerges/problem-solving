package leetcode;

public class SubarrayProductLessThanK
{
	public static void main(String[] args)
	{
		System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[] { 1,2,3 }, 0));
	}

	public int numSubarrayProductLessThanK(int[] nums, int k)
	{
		int answer = 0;
		int left = 0;
		int right = 0;
		long prod = 1;
		while (right < nums.length)
		{
			prod *= nums[right];
			while (left <= right && prod >= k)
			{
				prod /= nums[left];
				left++;
			}
			answer += (right - left + 1);
			right++;
		}
		return answer;
	}
}
