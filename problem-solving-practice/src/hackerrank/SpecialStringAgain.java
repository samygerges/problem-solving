package hackerrank;

public class SpecialStringAgain
{
	public static void main(String[] args)
	{
		System.out.println(substrCount(5, "asasd"));
	}

	static long substrCount(int n, String s)
	{
		long count = 0;
		count += s.length();
		for (int i = 0; i < n; i++)
		{
			int window = 1;
			while (i - window > -1 && i + window < n && s.charAt(i - window) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i + window))
			{
				window++;
				count++;
			}
			int rep = 0;
			while (i + 1 < n && s.charAt(i) == s.charAt(i + 1))
			{
				rep++;
				i++;
			}
			count += (rep * (rep + 1)) / 2;
		}
		return count;
	}
}
