package hackerrank;

import java.util.Arrays;
import java.util.List;

public class StockMaximize
{
	public static void main(String[] args)
	{
		System.out.println(stockmax(Arrays.asList(1, 2, 100)));
	}

	public static long stockmax(List<Integer> prices)
	{
		long max = 0;
		long maxSoFar = 0;

		for (int i = prices.size() - 1; i >= 0; i--)
		{
			if (maxSoFar <= prices.get(i))
			{
				maxSoFar = prices.get(i);
			}
			max += maxSoFar - prices.get(i);
		}
		return max;
	}
}
