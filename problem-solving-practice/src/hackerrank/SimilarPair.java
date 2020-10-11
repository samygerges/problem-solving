package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SimilarPair
{
	public static void main(String[] args)
	{
		System.out.println(similarPair(5, 2, new int[][] { { 3, 2 }, { 3, 1 }, { 1, 4 }, { 1, 5 } }));
	}

	static int similarPair(int n, int k, int[][] edges)
	{
		Map<Integer, Integer> parent = new HashMap<>();
		for (int[] i : edges)
		{
			parent.put(i[1], i[0]);
		}
		int count = 0;
		for (int i = 1; i <= n; i++)
		{
			int p = i;
			while (parent.containsKey(p))
			{
				p = parent.get(p);
				if (Math.abs(i - p) <= k)
				{
					count++;
				}
				if (parent.containsKey(p))
				{
					p = parent.get(p);
					if (Math.abs(i - p) <= k)
					{
						count++;
					}
				}
				else
				{
					p = -1;
				}
			}
		}
		return count;
	}
}
