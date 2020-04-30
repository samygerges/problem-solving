package hackerrank;

public class Encryption
{
	public static void main(String[] args)
	{
		System.out.println(encryption("feedthedog"));
	}

	static String encryption(String s)
	{
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray())
		{
			if (c != ' ')
			{
				sb.append(c);
			}
		}

		double len = Math.sqrt(sb.toString().length());
		int row = (int) Math.floor(len);
		int col = (int) Math.ceil(len);
		row = row * col >= sb.length() ? row : row + 1;

		char[][] arr = new char[row][col];
		int index = 0;
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (index >= s.length())
				{
					break;
				}
				arr[i][j] = s.charAt(index++);
			}
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < col; i++)
		{
			for (int j = 0; j < row; j++)
			{
				if (arr[j][i] != '\u0000')
				{
					result.append(arr[j][i]);
				}
			}
			if (i + 1 < col)
			{
				result.append(' ');
			}
		}

		return result.toString();
	}
}
