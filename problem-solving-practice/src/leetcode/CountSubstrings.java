package leetcode;

public class CountSubstrings
{
	public static void main(String[] args)
	{
		System.out.println(new CountSubstrings().countSubstrings("aba", "baba"));
	}

	public int countSubstrings(String s, String t)
	{
		int count = 0;
		for (int i = 0; i < s.length(); i++)
		{
			for (int j = 0; j < t.length(); j++)
			{
				int cnt = 0;
				for (int k = 0; i + k < s.length() && j + k < t.length(); k++)
				{
					if (s.charAt(i + k) != t.charAt(j + k))
					{
						cnt++;
					}
					if (cnt == 1)
					{
						count++;
					}
				}
			}
		}
		return count;
	}
}
