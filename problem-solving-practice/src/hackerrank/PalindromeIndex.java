package hackerrank;

public class PalindromeIndex
{
    public static void main(String[] args)
    {
        System.out.println(palindromeIndex("aaa"));
    }


    static int palindromeIndex(String s)
    {
        int index = -1;
        for (int i = 0; i < s.length() / 2; i++)
        {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
            {
                if (isPalindrome(s.substring(i + 1, s.length() - i)))
                {
                    index = i;
                }
                else if (isPalindrome(s.substring(i, s.length() - i - 1)))
                {
                    index = s.length() - i - 1;
                }
                break;
            }
        }
        return index;
    }


    static boolean isPalindrome(String s)
    {
        for (int i = 0; i < s.length() / 2; i++)
        {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
}
