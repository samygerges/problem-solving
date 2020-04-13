public class Anagram
{
    public static void main(String[] args)
    {
        System.out.println(anagram("aaabbb"));
    }


    static int anagram(String s)
    {
        if (s.length() % 2 != 0)
        {
            return -1;
        }
        int[] arr = new int[126];
        for (int i = 0; i < s.length() / 2; i++)
        {
            arr[s.charAt(i)]++;
        }
        for (int i = s.length() / 2; i < s.length(); i++)
        {
            arr[s.charAt(i)]--;
        }
        int changes = 0;
        for (int i = 0; i < arr.length; i++)
        {
            changes += Math.abs(arr[i]);
        }

        return changes / 2;
    }
}
