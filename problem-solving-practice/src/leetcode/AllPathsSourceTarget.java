package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget
{
	public static void main(String[] args)
	{
		AllPathsSourceTarget a = new AllPathsSourceTarget();
		System.out.println(a.allPathsSourceTarget(new int[][] { { 1, 2 }, { 3 }, { 3 }, {} }));
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph)
	{
		List<List<Integer>> res = new ArrayList<>();

		boolean[] visited = new boolean[graph.length];
		List<Integer> path = new ArrayList<>();
		path.add(0);
		visited[0] = true;
		backtrack(graph, 0, visited, path, res);

		return res;
	}

	private void backtrack(int[][] graph, int from, boolean[] visited, List<Integer> path, List<List<Integer>> res)
	{
		if (from == graph.length - 1)
		{
			res.add(new ArrayList<>(path));
			return;
		}

		for (int j = 0; j < graph[from].length; j++)
		{
			if (!visited[graph[from][j]])
			{
				visited[graph[from][j]] = true;
				path.add(graph[from][j]);
				backtrack(graph, graph[from][j], visited, path, res);
				visited[graph[from][j]] = false;
				path.remove(path.size() - 1);
			}
		}
	}
}
