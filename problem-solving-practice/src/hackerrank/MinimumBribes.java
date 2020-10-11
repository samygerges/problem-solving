package hackerrank;

public class MinimumBribes
{
	public static void main(String[] args)
	{
		minimumBribes(new int[] { 2, 5, 1, 3, 4 });
	}

	static void minimumBribes(int[] q)
	{
		for (int i = 0; i < q.length - 1; i++)
		{
			if (q[i] > i + 3)
			{
				System.out.println("Too chaotic");
				return;
			}
		}

		int bribes = 0;
		for (int i = q.length - 1; i > 0; i--)
		{
			for (int j = Math.max(0, q[i] - 2); j < i; j++)
			{
				if (q[j] > q[i])
				{
					bribes++;
				}
			}
		}
		System.out.println(bribes);
	}

	private static void swap(int[] a, int i, int j)
	{
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
