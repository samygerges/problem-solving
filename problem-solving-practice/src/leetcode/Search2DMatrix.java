package leetcode;

public class Search2DMatrix
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		if (matrix == null || matrix.length == 0)
		{
			return false;
		}

		int n = matrix.length;
		int m = matrix[0].length;
		int top = 0;
		int down = n - 1;
		int left = 0;
		int right = m - 1;

		while (top <= down && left <= right)
		{
			int midCol = left + (right - left) / 2;
			int midRow = top + (down - top) / 2;

			if (matrix[midRow][midCol] == target)
			{
				return true;
			}

			if (target > matrix[midRow][m - 1])
			{
				top = midRow + 1;
			}
			else if (target < matrix[midRow][0])
			{
				down = midRow - 1;
			}
			else if (matrix[midRow][midCol] > target)
			{
				right = midCol - 1;
			}
			else
			{
				left = midCol + 1;
			}
		}

		return false;
	}
}
