package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleIV
{
	public static void main(String[] args)
	{
		System.out.println(new CourseScheduleIV().checkIfPrerequisite(5,
			new int[][] { { 4, 3 }, { 4, 1 }, { 4, 0 }, { 3, 2 }, { 3, 1 }, { 3, 0 }, { 2, 1 }, { 2, 0 }, { 1, 0 } },
			new int[][] { { 1, 4 }, { 4, 2 }, { 0, 1 }, { 4, 0 }, { 0, 2 }, { 1, 3 }, { 0, 1 } }));
	}

	public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries)
	{
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++)
		{
			map.put(i, new HashSet<>());
		}
		for (int[] i : prerequisites)
		{
			map.get(i[0]).add(i[1]);
		}

		for (int i = 0; i < n; i++)
		{
			boolean[] visited = new boolean[n];
			visited[i] = true;
			Set<Integer> set = new HashSet<>(map.get(i));
			for (int j : set)
			{
				dfs(i, j, visited, map);
			}
		}
		List<Boolean> answer = new ArrayList<>();
		for (int[] i : queries)
		{
			if (map.get(i[0]).contains(i[1]))
			{
				answer.add(true);
			}
			else
			{
				answer.add(false);
			}
		}
		return answer;
	}

	private void dfs(int source, int node, boolean[] visited, Map<Integer, Set<Integer>> map)
	{
		visited[node] = true;
		for (int i : map.get(node))
		{
			map.get(source).add(i);
			if (!visited[i])
			{
				dfs(source, i, visited, map);
			}
		}
	}
}
