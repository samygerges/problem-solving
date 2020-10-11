package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximalNetworkRank
{
	public int maximalNetworkRank(int n, int[][] roads)
	{
		int max = 0;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < roads.length; i++)
		{
			map.putIfAbsent(roads[i][0], new HashSet<>());
			map.putIfAbsent(roads[i][1], new HashSet<>());
			map.get(roads[i][0]).add(roads[i][1]);
			map.get(roads[i][1]).add(roads[i][0]);
		}

		for (int i = 0; i < n; i++)
		{
			for (int j = i + 1; j < n; j++)
			{
				int x = map.containsKey(i) ? map.get(i).size() : 0;
				int y = map.containsKey(j) ? map.get(j).size() : 0;
				int diff = map.containsKey(i) && map.get(i).contains(j) ? 1 : 0;
				max = Math.max(x + y - diff, max);
			}
		}
		return max;
	}
}
