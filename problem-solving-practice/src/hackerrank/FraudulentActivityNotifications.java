package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class FraudulentActivityNotifications
{

	public static void main(String[] args)
	{
		System.out.println(activityNotifications(new int[] { 1, 2, 3, 4, 4 }, 4));
	}

	static int activityNotifications(int[] expenditure, int d)
	{
		int count = 0;
		int[] all = new int[201];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < d - 1; i++)
		{
			all[expenditure[i]]++;
		}

		for (int i = d; i < expenditure.length; i++)
		{
			all[expenditure[i]]++;
			double median = 0;
			int median1 = 0;
			int median2 = 0;
			int x = (d / 2);
			x += d % 2 != 0 ? 1 : 0;
			int y = (d / 2) + 1;
			boolean lock = false;
			for (int j = 0; j < 201; j++)
			{
				if (x > 0)
				{
					x -= all[j];
				}
				if (y > 0)
				{
					y -= all[j];
				}
				if (x <= 0 && !lock)
				{
					median1 = j;
					lock = true;
				}
				if (y <= 0)
				{
					median2 = j;
				}
				if (x <= 0 && y <= 0)
				{
					break;
				}
			}
			if (d % 2 == 0)
			{
				median = (median1 + median2) / 2.0;
			}
			else
			{
				median = median1;
			}
			if (expenditure[i] >= median * 2)
			{
				count++;
			}
			all[expenditure[i - d]]--;
		}
		return count;
	}
}
