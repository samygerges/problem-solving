package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CriticalConnections
{
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections)
	{
		Map<Integer, Set<Integer>> map = new HashMap<>();

		// filling map
		for (List<Integer> connection : connections)
		{
			map.computeIfAbsent(connection.get(0), node -> new HashSet<>()).add(connection.get(1));
			map.computeIfAbsent(connection.get(1), node -> new HashSet<>()).add(connection.get(0));
		}

		Set<List<Integer>> res = new HashSet<>(connections);
		int[] rank = new int[n];
		Arrays.fill(rank, -2);
		dfs(map, rank, 0, 0, res);
		return new ArrayList<>(res);
	}

	private int dfs(Map<Integer, Set<Integer>> map, int[] rank, int node, int depth, Set<List<Integer>> connections)
	{
		if (rank[node] > -1)
		{
			return rank[node];
		}
		rank[node] = depth;
		int min = depth;
		for (int current : map.get(node))
		{
			if (rank[current] < depth - 1)
			{
				int minDepth = dfs(map, rank, current, depth + 1, connections);
				min = Math.min(min, minDepth);
				if (minDepth <= depth)
				{
					connections.remove(Arrays.asList(node, current));
					connections.remove(Arrays.asList(current, node));
				}
			}
		}
		return min;
	}
}
