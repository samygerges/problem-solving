package leetcode;

public class KLengthApart
{
	public boolean kLengthApart(int[] nums, int k)
	{
		int count = -1;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] == 0 && count != -1)
			{
				count++;
			}
			if (nums[i] == 1)
			{
				if (count != -1 && count < k)
				{
					return false;
				}
				count = 0;
			}
		}
		return true;
	}
}
