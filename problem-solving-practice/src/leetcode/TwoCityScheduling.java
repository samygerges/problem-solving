package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoCityScheduling
{
	public static void main(String[] args)
	{
		System.out.println(new TwoCityScheduling().twoCitySchedCost(new int[][] { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } }));
		System.out.println(new TwoCityScheduling().twoCitySchedCost(
			new int[][] { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } }));
	}

	public int twoCitySchedCost(int[][] costs)
	{
		List<Candidate> list = new ArrayList<>();
		for (int i = 0; i < costs.length; i++)
		{
			list.add(new Candidate(costs[i][0], costs[i][1]));
		}

		Collections.sort(list);
		int a = costs.length / 2;
		int b = a;
		int sum = 0;

		for (int i = 0; i < list.size(); i++)
		{
			if ((list.get(i).a < list.get(i).b && a > 0) || b == 0)
			{
				sum += list.get(i).a;
				a--;
			}
			else
			{
				sum += list.get(i).b;
				b--;
			}
		}

		return sum;
	}

	class Candidate implements Comparable<Candidate>
	{
		int a;
		int b;

		public Candidate(int a, int b)
		{
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Candidate o)
		{
			if (Math.abs(a - b) > Math.abs(o.a - o.b))
			{
				return -1;
			}
			else if (Math.abs(a - b) < Math.abs(o.a - o.b))
			{
				return 1;
			}
			return 0;
		}
	}
}
