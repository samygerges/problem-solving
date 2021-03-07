package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.util.Pair;

public class MyHashMap
{

	Set<Integer> keys;
	List<Pair<Integer, Integer>> map;

	/**
	 * Initialize your data structure here.
	 */
	public MyHashMap()
	{
		keys = new HashSet<>();
		map = new ArrayList<>();
	}

	/**
	 * value will always be non-negative.
	 */
	public void put(int key, int value)
	{
		if (keys.contains(key))
		{
			for (int i = 0; i < map.size(); i++)
			{
				if (map.get(i).getKey() == key)
				{
					map.remove(i);
				}
			}
		}
		keys.add(key);
		map.add(new Pair<>(key, value));
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
	 */
	public int get(int key)
	{
		if (!keys.contains(key))
		{
			return -1;
		}
		for (int i = 0; i < map.size(); i++)
		{
			if (map.get(i).getKey() == key)
			{
				return map.get(i).getValue();
			}
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping for the key
	 */
	public void remove(int key)
	{
		if (keys.contains(key))
		{
			keys.remove(key);
			for (int i = 0; i < map.size(); i++)
			{
				if (map.get(i).getKey() == key)
				{
					map.remove(i);
				}
			}
		}
	}
}
