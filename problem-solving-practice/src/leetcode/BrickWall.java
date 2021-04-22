package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall
{
	public int leastBricks(List<List<Integer>> wall)
	{
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < wall.size(); i++)
		{
			int sum = 0;
			for (int j = 0; j < wall.get(i).size() - 1; j++)
			{
				sum += wall.get(i).get(j);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
				count = Math.max(count, map.get(sum));
			}
		}

		return wall.size() - count;
	}
}
