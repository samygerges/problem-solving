package leetcode;

public class ThousandSeparator
{
	public String thousandSeparator(int n)
	{
		String num = "" + n;
		for (int i = num.length() - 3; i > 0; i -= 3)
		{
			num = num.substring(0, i) + "." + num.substring(i);
		}
		return num;
	}
}
