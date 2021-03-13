package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumFactoredBinaryTrees
{
	public static void main(String[] args)
	{
		System.out.println(new NumFactoredBinaryTrees().numFactoredBinaryTrees(new int[] { 2, 4 }));
		System.out.println(new NumFactoredBinaryTrees().numFactoredBinaryTrees(new int[] { 2, 4, 5, 10 }));
		System.out.println(new NumFactoredBinaryTrees().numFactoredBinaryTrees(new int[] { 18, 3, 6, 2 }));
	}

	public int numFactoredBinaryTrees(int[] arr)
	{
		Arrays.sort(arr);
		long[] dp = new long[arr.length];
		Arrays.fill(dp, 1);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++)
		{
			map.put(arr[i], i);
		}

		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (arr[i] % arr[j] == 0)
				{
					if (map.containsKey(arr[i] / arr[j]))
					{
						dp[i] = (dp[i] + dp[j] * dp[map.get(arr[i] / arr[j])]) % 1_000_000_007;
					}
				}
			}
		}

		long sum = 0;
		for (long i : dp)
		{
			sum += i;
		}

		return (int) (sum % 1_000_000_007);
	}
}
