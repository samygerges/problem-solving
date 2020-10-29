package leetcode;

public class MaximizeDistanceClosestPerson
{
	public static void main(String[] args)
	{
		System.out.println(new MaximizeDistanceClosestPerson().maxDistToClosest(new int[] { 0, 0, 1 }));
	}

	public int maxDistToClosest(int[] seats)
	{
		int max = 0;
		int st = -1;
		int count = 0;
		for (int i = 0; i < seats.length; i++)
		{
			if (seats[i] == 0)
			{
				count++;
			}
			else
			{
				if (count > 0)
				{
					max = max == 0 && seats[0] == 0 ? Math.max(max, count) : Math.max(max, ((count + 1) / 2));
				}
				count = 0;
			}
		}
		if (count > 0)
		{
			max = Math.max(max, count);
		}
		return max;
	}
}
