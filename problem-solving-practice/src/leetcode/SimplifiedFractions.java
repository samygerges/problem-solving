package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimplifiedFractions
{

	public static void main(String[] args)
	{
		System.out.println(new SimplifiedFractions().simplifiedFractions(2));
	}

	public List<String> simplifiedFractions(int n)
	{
		List<Integer> up = new ArrayList<>();
		for (int i = 1; i < n; i++)
		{
			up.add(i);
		}
		if (up.isEmpty())
		{
			return Collections.emptyList();
		}
		List<Integer> down = new ArrayList<>();
		for (int i = 1; i <= n; i++)
		{
			down.add(i);
		}

		List<String> res = new ArrayList<>();
		Set<Double> simplifed = new HashSet<>();
		for (int i = 0; i < down.size(); i++)
		{
			for (int j = 0; j < up.size(); j++)
			{
				if (up.get(j) >= down.get(i))
				{
					continue;
				}
				if (!simplifed.contains((double) up.get(j) / (double) down.get(i)))
				{
					res.add(up.get(j) + "/" + down.get(i));
				}
				simplifed.add((double) up.get(j) / (double) down.get(i));
			}
		}
		return res;
	}
}
