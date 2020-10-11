package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule
{
	public static void main(String[] args)
	{
		System.out.println(
			new CourseSchedule().canFinish(7, new int[][] { { 1, 0 }, { 0, 3 }, { 0, 2 }, { 3, 2 }, { 2, 5 }, { 4, 5 }, { 5, 6 }, { 2, 4 } }));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites)
	{
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] i : prerequisites)
		{
			map.putIfAbsent(i[0], new ArrayList<>());
			map.get(i[0]).add(i[1]);
		}

		boolean[] visited = new boolean[numCourses];
		boolean[] recStack = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++)
		{
			if (isCyclic(i, visited, recStack, map))
			{
				return false;
			}
		}
		return true;
	}

	private boolean isCyclic(int node, boolean[] visited, boolean[] recStack, Map<Integer, List<Integer>> map)
	{
		if (recStack[node])
		{
			return true;
		}
		if (visited[node])
		{
			return false;
		}

		visited[node] = true;
		recStack[node] = true;

		if (map.containsKey(node))
		{
			for (int i : map.get(node))
			{
				if (isCyclic(i, visited, recStack, map))
				{
					return true;
				}
			}
		}
		recStack[node] = false;
		return false;
	}
}
