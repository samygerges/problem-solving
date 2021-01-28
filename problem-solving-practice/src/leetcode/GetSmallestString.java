package leetcode;

public class GetSmallestString
{
	public static void main(String[] args)
	{
		System.out.println(new GetSmallestString().getSmallestString(5, 31));
	}

	public String getSmallestString(int n, int k)
	{
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = 1;
			k--;
		}

		int index = n - 1;
		while (index >= 0 && k > 0)
		{
			if (k >= 26)
			{
				k -= 25;
				arr[index] = 26;
			}
			else
			{
				arr[index] = k + 1;
				k = 0;
			}
			index--;
		}
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < n; i++)
		{
			int x = 96 + arr[i];
			answer.append((char) x);
		}

		return answer.toString();
	}
}
