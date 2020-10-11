package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CutTree
{
	public static void main(String[] args)
	{
		Integer[] data = new Integer[] { 100, 200, 100, 500, 100, 600 };
		Integer[][] e = new Integer[][] { { 1, 2 }, { 2, 3 }, { 2, 5 }, { 4, 5 }, { 5, 6 } };
		List<List<Integer>> edges = new ArrayList<>();
		for (Integer[] a : e)
		{
			List<Integer> edge = new ArrayList<>();
			for (Integer i : a)
			{
				edge.add(i);
			}
			edges.add(edge);
		}
		System.out.println(cutTheTree(6, Arrays.asList(data), edges));
	}

	public static int cutTheTree(int n, List<Integer> data, List<List<Integer>> edges)
	{
		int sum = data.stream().reduce(0, Integer::sum);
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < edges.size(); i++)
		{
			map.putIfAbsent(edges.get(i).get(0), new ArrayList<>());
			map.putIfAbsent(edges.get(i).get(1), new ArrayList<>());
			map.get(edges.get(i).get(0)).add(edges.get(i).get(1));
			map.get(edges.get(i).get(1)).add(edges.get(i).get(0));
		}

		int min = Integer.MAX_VALUE;
		boolean[] visited = new boolean[n];
		int[] totals = new int[n];
		for (int i = 1; i < visited.length; i++)
		{
			if (!visited[i - 1] && map.containsKey(i))
			{
				dfs(i, map, data, visited, totals);
			}
		}

		for (int i = 0; i < edges.size(); i++)
		{
			int x = edges.get(i).get(0);
			int y = edges.get(i).get(1);
			min = Math.min(min, Math.abs(sum - totals[y - 1] - totals[y - 1]));
			min = Math.min(min, Math.abs(sum - totals[x - 1] - totals[x - 1]));
		}
		return min;
	}

	private static int dfs(int node, Map<Integer, List<Integer>> map, List<Integer> data, boolean[] visited, int[] totals)
	{
		totals[node - 1] = data.get(node - 1);
		visited[node - 1] = true;
		for (int i = 0; map.containsKey(node) && i < map.get(node).size(); i++)
		{
			if (!visited[map.get(node).get(i) - 1])
			{
				totals[node - 1] += dfs(map.get(node).get(i), map, data, visited, totals);
			}
		}
		return totals[node - 1];
	}
}