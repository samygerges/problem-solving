package leetcode;

public class RemoveKDigits
{
	public static void main(String[] args)
	{
		RemoveKDigits r = new RemoveKDigits();
		System.out.println(r.removeKdigits("5337", 2));
	}

	public String removeKdigits(String num, int k)
	{
		if (num.length() == k)
		{
			return "0";
		}

		for (int i = 0; i < num.length() - 1; i++)
		{
			if (k == 0)
			{
				break;
			}
			if (num.charAt(i) - '0' > num.charAt(i + 1) - '0')
			{
				num = num.substring(0, i) + num.substring(i + 1);
				i -= 2;
				if (i < 0)
				{
					i = -1;
				}
				k--;
			}
		}
		if (k > 0)
		{
			num = num.substring(0, num.length() - k);
		}
		int start = -1;
		for (int i = 0; i < num.length() - 1; i++)
		{
			if (num.charAt(i) != '0')
			{
				break;
			}
			start = i;
		}
		if (start != -1)
		{
			num = num.substring(start + 1);
		}
		return num.isEmpty() ? "0" : num;
	}
}
