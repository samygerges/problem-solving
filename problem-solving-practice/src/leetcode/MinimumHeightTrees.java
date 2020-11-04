package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees
{
	public static void main(String[] args)
	{
		System.out.println(new MinimumHeightTrees().findMinHeightTrees(4, new int[][] { { 1, 0 }, { 1, 2 }, { 1, 3 } }));
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges)
	{
		if (n < 2)
		{
			List<Integer> answer = new ArrayList<>();
			for (int i = 0; i < n; i++)
			{
				answer.add(i);
			}
			return answer;
		}
		List<Set<Integer>> children = new ArrayList<>();
		for (int i = 0; i < n; i++)
		{
			children.add(new HashSet<>());
		}

		for (int[] edge : edges)
		{
			children.get(edge[0]).add(edge[1]);
			children.get(edge[1]).add(edge[0]);
		}

		List<Integer> minHight = new ArrayList<>();

		for (int i = 0; i < n; i++)
		{
			if (children.get(i).size() == 1)
			{
				minHight.add(i);
			}
		}

		int max = n;

		while (max > 2)
		{
			max -= minHight.size();
			List<Integer> level = new ArrayList<>();
			for (int i : minHight)
			{
				for (int j : children.get(i))
				{
					children.get(j).remove(i);
					if (children.get(j).size() == 1)
					{
						level.add(j);
					}
				}
			}
			minHight = level;
		}

		return minHight;
	}
}
