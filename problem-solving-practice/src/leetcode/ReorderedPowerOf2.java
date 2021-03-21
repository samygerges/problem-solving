package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderedPowerOf2
{
	public boolean reorderedPowerOf2(int N)
	{
		List<char[]> all = new ArrayList<>();
		for (int i = 0; i <= 30; i++)
		{
			all.add(String.valueOf((int) Math.pow(2, i)).toCharArray());
		}

		char[] arr = String.valueOf(N).toCharArray();
		Arrays.sort(arr);
		for (int i = 0; i < all.size(); i++)
		{
			char[] comp = all.get(i);
			if (comp.length == arr.length)
			{
				Arrays.sort(comp);
				boolean check = true;
				for (int j = 0; j < comp.length; j++)
				{
					if (comp[j] != arr[j])
					{
						check = false;
						break;
					}
				}
				if (check)
				{
					return true;
				}
			}
		}

		return false;
	}
}
