package leetcode;

public class PrisonAfterNDays
{
	public static void main(String[] args)
	{
		PrisonAfterNDays a = new PrisonAfterNDays();
		int[] arr = a.prisonAfterNDays(new int[] { 1, 0, 0, 1, 0, 0, 0, 1 }, 826);
		System.out.println(a.convert(arr));
	}

	public int[] prisonAfterNDays(int[] cells, int N)
	{
		int days = N % 14 == 0 ? 14 : N % 14;
		for (int i = 0; i < days; i++)
		{
			int[] day = new int[8];
			for (int j = 0; j < 8; j++)
			{
				if (j == 0 || j == 7)
				{
					if (cells[j] == 1)
					{
						day[j] = 0;
					}
				}
				else
				{
					if (cells[j - 1] == cells[j + 1])
					{
						day[j] = 1;
					}
				}
			}
			cells = day;
		}
		return cells;
	}

	private String convert(int[] arr)
	{
		String res = "";
		for (int i : arr)
		{
			res += i;
		}
		return res;
	}
}
