package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet
{
	public static void main(String[] args)
	{
		RandomizedSet obj = new RandomizedSet();
		boolean param_1 = obj.insert(10);
		boolean param_2 = obj.remove(2);
		int param_3 = obj.getRandom();
		System.out.println(param_3);
	}

	private Map<Integer, Integer> map;
	private Map<Integer, Integer> index;
	private Random rand;
	private int size;

	/**
	 * Initialize your data structure here.
	 */
	public RandomizedSet()
	{
		size = 0;
		index = new HashMap<>();
		map = new HashMap<>();
		rand = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain the specified element.
	 */
	public boolean insert(int val)
	{
		boolean yes = map.containsKey(val);
		if (!yes)
		{
			map.put(val, size);
			index.put(size, val);
			size++;
		}
		return !yes;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified element.
	 */
	public boolean remove(int val)
	{
		Integer ind = map.remove(val);
		if (ind != null)
		{
			index.remove(ind);
			size--;
			if (ind != size)
			{
				Integer lastValue = index.remove(size);
				index.put(ind, lastValue);
				map.put(lastValue, ind);
			}
			return true;
		}
		return false;
	}

	/**
	 * Get a random element from the set.
	 */
	public int getRandom()
	{
		return index.get(rand.nextInt(size));
	}
}
