package leetcode;

public class ConsecutiveCharacters
{
	public static void main(String[] args)
	{
		System.out.println(new ConsecutiveCharacters().maxPower("abbcccddddeeeeedcba"));
	}

	public int maxPower(String s)
	{
		int max = 0;
		Character prev = null;
		int cnt = 1;
		for (int i = 0; i < s.length(); i++)
		{
			if (prev != null)
			{
				if (prev == s.charAt(i))
				{
					cnt++;
				}
				else
				{
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
			prev = s.charAt(i);
		}
		return Math.max(max, cnt);
	}
}
