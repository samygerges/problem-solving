package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoPluses
{
	public static void main(String[] args)
	{
		System.out.println(twoPluses(new String[] { "GGGGGG", "GBBBGB", "GGGGGG", "GGBBGB", "GGGGGG" }));
		System.out.println(twoPluses(new String[] { "BGBBGB", "GGGGGG", "BGBBGB", "GGGGGG", "BGBBGB", "BGBBGB" }));
	}

	static int twoPluses(String[] grid)
	{
		if (grid == null || grid.length == 0)
		{
			return 0;
		}
		char[][] arr = new char[grid.length][grid[0].length()];
		for (int i = 0; i < grid.length; i++)
		{
			arr[i] = grid[i].toCharArray();
		}

		List<Plus> all = new ArrayList<>();
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				if (arr[i][j] == 'G')
				{
					Plus plus = getPlus(arr, i, j);
					if (plus != null)
					{
						all.add(plus);
					}
				}
			}
		}
		for (int i = 0; i < all.size(); i++)
		{
			for (int j = 0; j < all.size(); j++)
			{
				if (i == j)
				{
					continue;
				}
				else
				{
					int start_x = all.get(i).x - all.get(i).size;
					int end_x = all.get(i).x + all.get(i).size;
					int start_y = all.get(i).y - all.get(i).size;
					int end_y = all.get(i).y + all.get(i).size;

					int start_x2 = all.get(j).x - all.get(j).size;
					int end_x2 = all.get(j).x + all.get(j).size;
					int start_y2 = all.get(j).y - all.get(j).size;
					int end_y2 = all.get(j).y + all.get(j).size;

					if (inRange(start_x, end_x, start_x2, end_x2) && inRange(start_y, end_y, start_y2, end_y2))
					{
						if (all.get(i).area > all.get(j).area)
						{
							all.get(j).area = 0;
						}
						else
						{
							all.get(i).area = 0;
						}
					}
				}
			}
		}
		Collections.sort(all);
		int area = 1;
		for (int i = 0; i < 2 && i < all.size(); i++)
		{
			area *= all.get(i).area;
		}
		return area;
	}

	private static boolean inRange(int start, int end, int start2, int end2)
	{
		for (int i = start; i <= end; i++)
		{
			for (int j = start2; j <= end2; j++)
			{
				if (i == j)
				{
					return true;
				}
			}
		}
		return false;
	}

	private static Plus getPlus(char[][] arr, int x, int y)
	{
		Plus plus = new Plus();
		plus.x = x;
		plus.y = y;
		plus.size = 0;
		plus.area = 1;
		int n = Math.min(arr.length, arr[x].length);
		for (int i = 1; i < n; i++)
		{
			if (x + i < arr.length && x - i > -1 && y + i < arr[x].length && y - i > -1 && arr[x + 1][y] == 'G' && arr[x - i][y] == 'G'
				&& arr[x][y + i] == 'G' && arr[x][y - i] == 'G')
			{
				plus.area += 4;
				plus.size++;
			}
			else
			{
				break;
			}
		}
		return plus;
	}

	static class Plus implements Comparable<Plus>
	{
		int x;
		int y;
		int size;
		int area;

		@Override
		public int compareTo(Plus o)
		{
			return o.area - area;
		}
	}
}
