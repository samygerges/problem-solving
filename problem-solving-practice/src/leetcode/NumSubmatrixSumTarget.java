package leetcode;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class NumSubmatrixSumTarget
{
	public static void main(String[] args)
	{
		System.out.println(new NumSubmatrixSumTarget().numSubmatrixSumTarget(new int[][] { { 1, -1 }, { -1, 1 } }, 0));
	}

	private Map<Pair<Integer, Integer>, Integer> all = new HashMap<>();
	private Map<Pair<Integer, Integer>, Integer> row = new HashMap<>();
	private Map<Pair<Integer, Integer>, Integer> column = new HashMap<>();

	public int numSubmatrixSumTarget(int[][] matrix, int target)
	{
		if (matrix == null || matrix.length == 0)
		{
			return 0;
		}

		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] prefixSum = new int[rows + 1][columns];

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				prefixSum[i + 1][j] = prefixSum[i][j] + matrix[i][j];
			}
		}

		int result = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < rows; i++)
		{
			for (int j = i; j < rows; j++)
			{
				map.clear();
				int sum = 0;
				for (int k = 0; k < columns; k++)
				{
					sum += prefixSum[j + 1][k] - prefixSum[i][k];

					if (sum == target)
					{
						result++;
					}

					int difference = sum - target;
					if (map.containsKey(difference))
					{
						result += map.get(difference);
					}

					if (map.containsKey(sum))
					{
						map.put(sum, map.get(sum) + 1);
					}
					else
					{
						map.put(sum, 1);
					}
				}
			}
		}
		return result;
	}
}
