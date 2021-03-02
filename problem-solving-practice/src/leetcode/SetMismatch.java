package leetcode;

public class SetMismatch
{
	public int[] findErrorNums(int[] nums)
	{
		int[] counts = new int[nums.length + 1];
		for (int i : nums)
		{
			counts[i]++;
		}

		int[] answer = new int[2];
		int st = 1;
		int end = nums.length;
		for (int i = 1; i < counts.length; i++)
		{
			if (counts[i] > 1)
			{
				answer[0] = i;
			}
			if (counts[i] == 0)
			{
				answer[1] = i;
			}
		}
		return answer;
	}
}
