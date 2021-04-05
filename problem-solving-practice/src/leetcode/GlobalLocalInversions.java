package leetcode;

import java.util.Arrays;

public class GlobalLocalInversions
{
	public static void main(String[] args)
	{
		System.out.println(new GlobalLocalInversions().isIdealPermutation(new int[] { 0, 2, 1 }));
	}

	public boolean isIdealPermutation(int[] A)
	{
		if (A == null || A.length == 0)
		{
			return true;
		}

		int[] correct = Arrays.copyOf(A, A.length);
		Arrays.sort(correct);
		int local = 0;
		for (int i = 1; i < A.length; i++)
		{
			if (A[i - 1] > A[i])
			{
				local++;
			}
		}

		int global = 0;
		for (int i = 0; i < correct.length; i++)
		{
			int diff = A[i] - correct[i];
			if (diff > 0)
			{
				global += diff * (diff + 1) / 2;
			}
		}

		return global == local;
	}
}
