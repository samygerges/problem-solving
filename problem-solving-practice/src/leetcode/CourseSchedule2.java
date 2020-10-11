package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CourseSchedule2
{
	public static void main(String[] args)
	{
		CourseSchedule2 c = new CourseSchedule2();
		Arrays.stream(c.findOrder(2, new int[][] { { 0, 1 }, { 1, 0 } })).forEach(System.out::println);
	}

	public int[] findOrder(int numCourses, int[][] prerequisites)
	{
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] i : prerequisites)
		{
			map.putIfAbsent(i[0], new ArrayList<>());
			map.get(i[0]).add(i[1]);
		}

		boolean[] visited = new boolean[numCourses];
		boolean[] recStack = new boolean[numCourses];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < numCourses; i++)
		{
			boolean cycle = topologicalSort(i, map, visited, recStack, stack);
			if (cycle)
			{
				return new int[] {};
			}
		}
		int i = numCourses - 1;
		int[] answer = new int[numCourses];
		while (!stack.isEmpty())
		{
			answer[i--] = stack.pop();
		}
		return answer;
	}

	private boolean topologicalSort(int course, Map<Integer, List<Integer>> map, boolean[] visited, boolean[] recStack, ArrayDeque<Integer> stack)
	{
		if (recStack[course])
		{
			return true;
		}
		if (visited[course])
		{
			return false;
		}
		recStack[course] = true;
		visited[course] = true;
		if (map.containsKey(course))
		{
			for (int i = 0; i < map.get(course).size(); i++)
			{
				if (topologicalSort(map.get(course).get(i), map, visited, recStack, stack))
				{
					return true;
				}
			}
		}
		recStack[course] = false;
		stack.push(course);
		return false;
	}
}
