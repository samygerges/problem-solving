package leetcode;

public class RemovePalindromeSub
{
	public int removePalindromeSub(String s)
	{
		if (s == null || s.isEmpty())
		{
			return 0;
		}

		boolean isPalindrom = true;
		for (int i = 0; i < s.length() / 2; i++)
		{
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
			{
				isPalindrom = false;
				break;
			}
		}

		if (isPalindrom)
		{
			return 1;
		}
		return 2;
	}
}
