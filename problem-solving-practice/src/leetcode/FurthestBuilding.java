package leetcode;

import java.util.PriorityQueue;

public class FurthestBuilding
{
	public static void main(String[] args)
	{
		System.out.println(new FurthestBuilding().furthestBuilding(new int[] { 4, 2, 7, 6, 9, 14, 12 }, 5, 1));
	}

	public int furthestBuilding(int[] heights, int bricks, int ladders)
	{
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int i;
		for (i = 1; i < heights.length; i++)
		{
			if (heights[i] - heights[i - 1] > 0)
			{
				queue.add(heights[i] - heights[i - 1]);
				if (queue.size() > ladders)
				{
					bricks -= queue.poll();
				}
				if (bricks < 0)
				{
					break;
				}
			}
		}
		return i - 1;
	}
}
