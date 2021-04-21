package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle
{
	public static void main(String[] args)
	{
		List<List<Integer>> all = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(2);
		List<Integer> l2 = new ArrayList<>();
		l2.add(3);
		l2.add(4);
		List<Integer> l3 = new ArrayList<>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		List<Integer> l4 = new ArrayList<>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		all.add(l1);
		all.add(l2);
		all.add(l3);
		all.add(l4);
		System.out.println(new Triangle().minimumTotal(all));
	}

	public int minimumTotal(List<List<Integer>> triangle)
	{
		Integer[][] dp = new Integer[triangle.size()][triangle.size()];
		dp[0][0] = triangle.get(0).get(0);
		if (triangle.size() > 1)
		{
			dp[0][0] += getMin(triangle, 0, 0, dp);
		}
		return dp[0][0];
	}

	private int getMin(List<List<Integer>> triangle, int index, int row, Integer[][] dp)
	{
		if (row + 2 == triangle.size())
		{
			dp[row][index] = Math.min(triangle.get(row + 1).get(index), triangle.get(row + 1).get(index + 1));
		}
		else if (row + 1 < triangle.size())
		{
			if (dp[row + 1][index] == null)
			{
				dp[row + 1][index] = triangle.get(row + 1).get(index) + getMin(triangle, index, row + 1, dp);
			}
			if (dp[row + 1][index + 1] == null)
			{
				dp[row + 1][index + 1] = triangle.get(row + 1).get(index + 1) + getMin(triangle, index + 1, row + 1, dp);
			}
			dp[row][index] = Math.min(dp[row + 1][index], dp[row + 1][index + 1]);
		}
		return dp[row][index];
	}
}
