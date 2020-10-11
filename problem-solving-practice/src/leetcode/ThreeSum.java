package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum
{
	public static void main(String[] args)
	{
		ThreeSum sum = new ThreeSum();
		System.out.println(sum.threeSumOptimized(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(sum.threeSumOptimized(new int[] { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 }));
	}

	public List<List<Integer>> threeSum(int[] nums)
	{
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		Set<Set<Integer>> all = new HashSet<>();
		for (int i = 0; i < nums.length; i++)
		{
			int a = nums[i];
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = i + 1; j < nums.length; j++)
			{
				int c = nums[j];
				if (map.containsKey(-c - a) && map.get(-c - a) == -1)
				{
					List<Integer> triplets = new ArrayList<>();
					triplets.add(a);
					triplets.add(-c - a);
					triplets.add(c);
					Set<Integer> set = new HashSet<>(triplets);
					if (all.add(set))
					{
						res.add(triplets);
					}
					map.put(-c - a, c);
				}
				else
				{
					map.put(c, -1);
				}
			}
		}
		return res;
	}

	public List<List<Integer>> threeSumOptimized(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++)
		{
			if (i > 0 && nums[i] == nums[i - 1])
			{
				continue;
			}

			int j = i + 1;
			int k = nums.length - 1;
			int value = -nums[i];
			while (j < k)
			{
				if (nums[j] + nums[k] == value)
				{
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1])
					{
						j++;
					}

					while (j < k && nums[k] == nums[k + 1])
					{
						k--;
					}
				}
				else if (nums[j] + nums[k] > value)
				{
					k--;
				}
				else
				{
					j++;
				}
			}
		}
		return result;
	}
}
