package leetcode;

public class SplitTwoStringstoMakePalindrome
{
	public static void main(String[] args)
	{
		System.out.println(new SplitTwoStringstoMakePalindrome().checkPalindromeFormation("abda", "acmc"));
	}

	public boolean checkPalindromeFormation(String a, String b)
	{
		return helper(a, b) || helper(b, a);
	}

	private boolean helper(String a, String b)
	{
		int i = 0;
		int j = a.length() - 1;
		while (i <= j && a.charAt(i) == b.charAt(j))
		{
			i++;
			j--;
		}
		return isPalindrome(a, i, j) || isPalindrome(b, i, j);
	}

	private boolean isPalindrome(String s, int i, int j)
	{
		while (i < j && s.charAt(i) == s.charAt(j))
		{
			i++;
			j--;
		}
		return i >= j;
	}
}
