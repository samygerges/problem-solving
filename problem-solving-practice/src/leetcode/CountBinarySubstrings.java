package leetcode;

public class CountBinarySubstrings
{
	public int countBinarySubstrings(String s)
	{
		int len = 1;
		int prev = 0;
		int count = 0;

		for (int i = 1; i < s.length(); i++)
		{
			if (s.charAt(i) == s.charAt(i - 1))
			{
				len++;
			}
			else
			{
				prev = len;
				len = 1;
			}
			if(prev >= len) {
				count++;
			}
		}

		return count;
	}
}
