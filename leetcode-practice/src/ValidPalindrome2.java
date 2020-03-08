
public class ValidPalindrome2
{

    public static void main(String[] args)
    {
        ValidPalindrome2 v = new ValidPalindrome2();
        System.out.println(v.validPalindrome("deeee"));
    }


    public boolean validPalindrome(String s)
    {
        if (s == null || s.length() < 3)
            return true;
        char[] arr = s.toCharArray();
        return validPalindrome(arr, 0, arr.length - 1, 0);
    }


    private boolean validPalindrome(char[] arr, int i, int j, int wrong)
    {
        if (wrong > 1)
            return false;
        while (i < j)
        {
            if (arr[i] != arr[j])
            {
                return validPalindrome(arr, i + 1, j, wrong + 1)
                    ||
                    validPalindrome(arr, i, j - 1, wrong + 1);
            }
            i++;
            j--;
        }
        return true;
    }
}
