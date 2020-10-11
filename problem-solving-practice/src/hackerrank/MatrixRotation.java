package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MatrixRotation
{
	public static void main(String[] args)
	{
		//Integer[][] arr = new Integer[][] { { 1, 2, 3, 4, }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		Integer[][] arr = new Integer[][] { { 1, 2, 3, 4, }, { 7, 8, 9, 10 }, { 13, 14, 15, 16 }, { 19, 20, 21, 22 }, { 25, 26, 27, 28 } };

		List<List<Integer>> matrix = new ArrayList<>();
		for (int i = 0; i < arr.length; i++)
		{
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j < arr[i].length; j++)
			{
				row.add(arr[i][j]);
			}
			matrix.add(row);
		}
		matrixRotation(matrix, 2);
	}

	static void matrixRotation(List<List<Integer>> matrix, int r)
	{
		int[][] arr = new int[matrix.size()][matrix.get(0).size()];
		for (int i = 0; i < matrix.size(); i++)
		{
			for (int j = 0; j < matrix.get(i).size(); j++)
			{
				arr[i][j] = matrix.get(i).get(j);
			}
		}

		int size = Math.min(matrix.size(), matrix.get(0).size());
		int upToRow = size % 2 == 0 ? size / 2 : (size / 2) + 1;

		for (int rotate = 0; rotate < r; rotate++)
		{
			for (int row = 0; row < upToRow; row++)
			{
				int srow = row;
				int scol = row;
				int tmp = arr[srow][scol];
				int dirRow = 1;
				int dirCol = 0;
				int limitRow = arr.length - row;
				int limitCol = arr[row].length - row;
				while (true)
				{
					if (srow + 1 == limitRow && dirRow == 1 && dirCol == 0)
					{
						dirRow = 0;
						dirCol = 1;
					}
					else if (srow + 1 == limitRow && dirRow == 0 && dirCol == 1 && scol + 1 == limitCol)
					{
						dirRow = -1;
						dirCol = 0;
					}
					else if (srow == row && dirRow == -1 && dirCol == 0 && scol + 1 == limitCol)
					{
						dirCol = -1;
						dirRow = 0;
					}
					srow += dirRow;
					scol += dirCol;
					if (srow == row && scol == row - 1)
					{
						break;
					}
					//System.out.println(rotate + " " + row + " " + srow + " " + scol);
					int tmp2 = arr[srow][scol];
					arr[srow][scol] = tmp;
					tmp = tmp2;
				}
			}
		}

		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				System.out.print(arr[i][j]);
				if (j + 1 < arr[i].length)
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
