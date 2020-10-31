package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FrequencySort
{
	public int[] frequencySort(int[] nums)
	{
		Map<Integer, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < nums.length; i++)
		{
			if (map.containsKey(nums[i]))
			{
				map.put(nums[i], map.get(nums[i]) + 1);
			}
			else
			{
				map.put(nums[i], 1);
			}
		}

		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>()
		{
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
			{
				if (o1.getValue() == o2.getValue())
				{
					return o2.getKey() - o1.getKey();
				}
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		int index = 0;
		for (int i = 0; i < list.size(); i++)
		{
			for (int j = 0; j < list.get(i).getValue(); j++)
			{
				nums[index++] = list.get(i).getKey();
			}
		}
		return nums;
	}
}
