package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindSmallestSetOfVertices
{
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges)
	{
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < edges.size(); i++)
		{
			map.putIfAbsent(edges.get(i).get(0), new HashSet<>());
			map.get(edges.get(i).get(0)).add(edges.get(i).get(1));
			if (map.containsKey(edges.get(i).get(1)))
			{
				map.get(edges.get(i).get(0)).addAll(map.get(edges.get(i).get(1)));
			}
		}

		Set<Integer> all = new HashSet<>();
		List<Set<Integer>> mapValues = new ArrayList<>(map.values());
		Collections.sort(mapValues, (o1, o2) -> Integer.compare(o2.size(), o1.size()));
		for (int i = 0; i < mapValues.size(); i++)
		{
			all.addAll(mapValues.get(i));
			if (all.size() == n)
			{
				break;
			}
		}
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if(!all.contains(i)) {
				result.add(i);
			}
		}
		return result;
	}
}
