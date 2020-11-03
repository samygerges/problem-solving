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

	public int maxPowerOptimized(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		int max = 1;
		int cnt = 1;
		for (int i = 1; i < s.length(); i++)
		{
			cnt = s.charAt(i - 1) == s.charAt(i) ? cnt + 1 : 1;
			max = Math.max(cnt, max);
		}
		return max;
	}
}
