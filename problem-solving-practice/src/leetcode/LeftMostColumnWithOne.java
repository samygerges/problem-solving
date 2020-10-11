package leetcode;

import java.util.List;

interface BinaryMatrix
{
	int get(int x, int y);

	List<Integer> dimensions();
}

public class LeftMostColumnWithOne
{
	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix)
	{
		List<Integer> dimensions = binaryMatrix.dimensions();
		int n = dimensions.get(0);
		int m = dimensions.get(1);

		int x = 0, y = m - 1;

		int pos;
		int oneY = -1;
		while (x < n && y > -1)
		{
			pos = binaryMatrix.get(x, y);
			if (pos == 0)
			{
				x++;
			}
			else
			{
				oneY = y;
				y--;
			}
		}
		return oneY;
	}
}
