package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII
{
	public static void main(String[] args)
	{
		System.out.println(new PermutationsII().permuteUnique(new int[] { 1, 2, 3 }));
	}

	public List<List<Integer>> permuteUnique(int[] nums)
	{
		Set<List<Integer>> ans = new HashSet<>();
		permuteUnique(nums, new boolean[nums.length], ans, new ArrayList<>());
		return new ArrayList<>(ans);
	}

	private void permuteUnique(int[] nums, boolean[] visited, Set<List<Integer>> ans, List<Integer> current)
	{
		if (current.size() == nums.length)
		{
			ans.add(new ArrayList<>(current));
			return;
		}

		for (int i = 0; i < nums.length; i++)
		{
			if (!visited[i])
			{
				visited[i] = true;
				current.add(nums[i]);
				permuteUnique(nums, visited, ans, current);
				current.remove(current.size() - 1);
				visited[i] = false;
			}
		}
	}
}
