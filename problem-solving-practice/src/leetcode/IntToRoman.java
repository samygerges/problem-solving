package leetcode;

public class IntToRoman
{
	public String intToRoman(int num)
	{
		int[] number = { 1, 5, 10, 50, 100, 500, 1000 };
		String[] symbols = { "I", "V", "X", "L", "C", "D", "M" };
		StringBuilder result = new StringBuilder();
		while (num != 0)
		{
			for (int i = number.length - 1; i >= 0; i--)
			{
				if (num >= 400 && num < 500)
				{
					num -= 400;
					result.append(symbols[4]).append(symbols[5]);
					break;
				}
				else if (num >= 900 && num < 1000)
				{
					num -= 900;
					result.append(symbols[4]).append(symbols[6]);
					break;
				}
				else if (num >= 40 && num < 50)
				{
					num -= 40;
					result.append(symbols[2]).append(symbols[3]);
					break;
				}
				else if (num >= 90 && num < 100)
				{
					num -= 90;
					result.append(symbols[2]).append(symbols[4]);
					break;
				}
				else if (num == 4)
				{
					num -= 4;
					result.append(symbols[0]).append(symbols[1]);
					break;
				}
				else if (num == 9)
				{
					num -= 9;
					result.append(symbols[0]).append(symbols[2]);
					break;
				}
				else
				{
					if (num >= number[i])
					{
						num -= number[i];
						result.append(symbols[i]);
						break;
					}
				}
			}
		}
		return result.toString();
	}
}
