package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement2
{
	public static void main(String[] args)
	{
		System.out.println(new MajorityElement2().majorityElement(new int[] { 1,1,1,3,3,2,2,2 }));
	}

	public List<Integer> majorityElement(int[] nums)
	{
		Arrays.sort(nums);
		int times = (nums.length / 3) + 1;
		List<Integer> ans = new ArrayList<>();
		int prev = -1;
		int count = 0;
		for (int num : nums)
		{
			if (num != prev)
			{
				if (count >= times)
				{
					ans.add(prev);
				}
				prev = num;
				count = 1;
			}
			else
			{
				count++;
			}
		}
		if (count >= times)
		{
			ans.add(prev);
		}
		return ans;
	}
}
