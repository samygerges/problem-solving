package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers
{
	public static void main(String[] args)
	{
		System.out.println(new PowerfulIntegers().powerfulIntegers(1, 1, 400000));
	}

	public List<Integer> powerfulIntegers(int x, int y, int bound)
	{
		Set<Integer> xs = new HashSet<>();
		int pow = 1;
		while (pow < bound)
		{
			xs.add(pow);
			if (x == 1)
			{
				break;
			}
			pow *= x;
		}
		Set<Integer> ys = new HashSet<>();
		pow = 1;
		while (pow < bound)
		{
			ys.add(pow);
			if (y == 1)
			{
				break;
			}
			pow *= y;
		}
		Set<Integer> res = new HashSet<>();
		for (int i : xs)
		{
			for (int j : ys)
			{
				if (i + j <= bound)
				{
					res.add(i + j);
				}
			}
		}
		return new ArrayList<>(res);
	}
}
