package leetcode;

public class BeautifulArrangement2
{
	public static void main(String[] args)
	{
		System.out.println(new BeautifulArrangement2().constructArray(10000, 9999));
	}

	public int[] constructArray(int n, int k)
	{
		int[] res = new int[n];
		for (int i = 0; i < n; i++)
		{
			res[i] = i + 1;
		}
		int startFrom = n - k + 1;
		while (k > 1)
		{
			for (int i = n - 1; i >= startFrom; i--)
			{
				int tmp = res[i];
				res[i] = res[i - 1];
				res[i - 1] = tmp;
			}
			k -= 2;
			startFrom += 2;
		}

		return res;
	}
}
