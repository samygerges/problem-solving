package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2
{
	public List<Integer> getRow(int rowIndex)
	{
		List<List<Integer>> all = new ArrayList<>();
		all.add(new ArrayList<>());
		all.add(new ArrayList<>());

		all.get(0).add(1);
		all.get(1).add(1);
		all.get(1).add(1);
		for (int i = 2; i <= rowIndex; i++)
		{
			all.add(new ArrayList<>());
			all.get(i).add(1);
			for (int j = 1; j < i; j++)
			{
				all.get(i).add(all.get(i - 1).get(j - 1) + all.get(i - 1).get(j));
			}
			all.get(i).add(1);
		}

		return all.get(rowIndex);
	}
}
