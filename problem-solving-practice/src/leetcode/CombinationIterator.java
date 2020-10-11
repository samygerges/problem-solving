package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationIterator
{
	private List<String> combination;
	private int index = 0;

	public CombinationIterator(String characters, int combinationLength)
	{
		combination = new ArrayList<>();
		for (int i = 0; i < Math.pow(2, characters.length()); i++)
		{
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < characters.length(); j++)
			{
				if ((i & (1 << j)) > 0)
				{
					sb.append(characters.charAt(j));
				}
			}
			if (sb.length() == combinationLength)
			{
				combination.add(sb.toString());
			}
		}
		Collections.sort(combination);
	}

	public String next()
	{
		return combination.get(index++);
	}

	public boolean hasNext()
	{
		if(index >= combination.size()) {
			return false;
		}
		return true;
	}
}
