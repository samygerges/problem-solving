package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PossibleBipartition
{
	public static void main(String[] args)
	{
		System.out.println(new PossibleBipartition().possibleBipartition(5, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } }));
	}

	public boolean possibleBipartition(int N, int[][] dislikes)
	{
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < dislikes.length; i++)
		{
			int x = dislikes[i][0];
			int y = dislikes[i][1];
			map.putIfAbsent(x, new HashSet<>());
			map.putIfAbsent(y, new HashSet<>());
			map.get(x).add(y);
			map.get(y).add(x);
		}

		int[] colorNodes = new int[N + 1];
		for (int i = 1; i <= N; i++)
		{
			if (colorNodes[i] == 0 && !dfs(colorNodes, map, 1, i))
			{
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int[] colorNodes, Map<Integer, Set<Integer>> map, int color, int node)
	{
		if (colorNodes[node] != 0)
		{
			return colorNodes[node] == color;
		}
		colorNodes[node] = color;
		if (map.get(node) == null)
		{
			return true;
		}
		for (int i : map.get(node))
		{
			if (!dfs(colorNodes, map, -color, i))
			{
				return false;
			}
		}
		return true;
	}
}
