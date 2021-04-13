package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer>
{
	private List<Integer> list;
	private Iterator<Integer> iterator;

	public NestedIterator(List<NestedInteger> nestedList)
	{
		list = new ArrayList<>();
		getList(nestedList, list);
		iterator = list.iterator();
	}

	@Override
	public Integer next()
	{
		return iterator.next();
	}

	@Override
	public boolean hasNext()
	{
		return iterator.hasNext();
	}

	private void getList(List<NestedInteger> nestedList, List<Integer> list)
	{
		if (nestedList == null)
		{
			return;
		}
		for (NestedInteger nestedInteger : nestedList)
		{
			if (nestedInteger.isInteger())
			{
				list.add(nestedInteger.getInteger());
			}
			else
			{
				getList(nestedInteger.getList(), list);
			}
		}
	}
}

/**
 * // This is the interface that allows for creating nested lists. // You should not implement it, or speculate about its implementation
 */
interface NestedInteger
{

	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return empty list if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

