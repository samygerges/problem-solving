package leetcode;

public class MinOperations
{
	public static void main(String[] args)
	{
		System.out.println(new MinOperations().minOperations(new int[] { 123456789,987654321 }));
	}

	public int minOperations(int[] nums)
	{
		int ops = 0;
		int multi = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] % 2 != 0)
			{
				nums[i]--;
				ops++;
			}
			if (nums[i] == 0)
			{
				count++;
			}
		}

		for (int i = 0; i < nums.length; i++){
			int m = 0;
			while (nums[i] > 1)
			{
				m++;
				if (nums[i] % 2 != 0)
				{
					ops++;
					nums[i]--;
				}
				nums[i] /= 2;
			}
			multi = Math.max(multi, m);
		}
		return ops + multi + nums.length - count;
	}
}
