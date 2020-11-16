package leetcode;

public class LongestMountain
{
	public static void main(String[] args)
	{
		System.out.println(new LongestMountain().longestMountain(new int[] { 2, 1, 4, 7, 3, 2, 5 })); // 5
		System.out.println(new LongestMountain().longestMountain(new int[] { 2, 2, 2 })); // 0
		System.out.println(new LongestMountain().longestMountain(new int[] { 1, 2, 0, 2, 0, 2 })); // 3
	}

	public int longestMountain(int[] A)
	{
		int max = 0;
		for (int i = 1; i < A.length - 1; i++)
		{
			if (A[i] > A[i - 1] && A[i] > A[i + 1])
			{
				int count = 3;
				for (int j = i - 2; j >= 0; j--)
				{
					if (A[j] < A[j + 1])
					{
						count++;
					}
					else
					{
						break;
					}
				}
				for (int j = i + 2; j < A.length; j++)
				{
					if (A[j] < A[j - 1])
					{
						count++;
					}
					else
					{
						break;
					}
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}
}
