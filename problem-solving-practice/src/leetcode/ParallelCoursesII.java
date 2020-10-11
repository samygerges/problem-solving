package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ParallelCoursesII
{
	public static void main(String[] args)
	{
		ParallelCoursesII p = new ParallelCoursesII();
		System.out.println(p.minNumberOfSemesters(4, new int[][] { { 2, 1 }, { 3, 1 }, { 1, 4 } }, 2));
		System.out.println(p.minNumberOfSemesters(4, new int[][] { { 2, 1 }, { 2, 4 } }, 2));
	}

	public int minNumberOfSemesters(int n, int[][] dependencies, int k)
	{
		double count = 0;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++)
		{
			map.put(i, new HashSet<>());
		}
		for (int i = 0; i < dependencies.length; i++)
		{
			map.get(dependencies[i][1]).add(dependencies[i][0]);
		}

		Stack<Integer> stack = new Stack<>();
		int sem = 0;
		for (int i = 1; i <= n; i++)
		{
			stack.push(i);
			boolean calc = true;
			if (!visited[i])
			{
				sem++;
			}
			while (!stack.isEmpty())
			{
				int size = 0;
				int course = stack.pop();
				for (int j : map.get(course))
				{
					if (!visited[j])
					{
						calc = false;
						size++;
						stack.push(j);
						visited[j] = true;
					}
				}
				if (!calc && size > 0)
				{
					count += (double) size / (double) k;
					calc = true;
				}
			}
			count += (double) sem / (double) k;
			sem = 0;
			visited[i] = true;

		}
		if (sem > 0)
		{
			count += (double) sem / (double) k;
		}
		if (count > (int) count)
		{
			count++;
		}
		if (count == 0)
		{
			if (n % k == 0)
			{
				return n / k;
			}
			else
			{
				return (n / k) + 1;
			}
		}

		return (int) count;
	}
}
