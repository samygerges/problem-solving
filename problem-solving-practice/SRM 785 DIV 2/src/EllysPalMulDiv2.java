public class EllysPalMulDiv2 {

    public int getMin(int X) {
    	for(int i = 1; i <= 1000; i++)
		{
			if(isPalindrome(""+ (X*i)))
				return i;
		}
        return -1;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}