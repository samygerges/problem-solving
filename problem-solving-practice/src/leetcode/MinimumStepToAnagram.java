package leetcode;

public class MinimumStepToAnagram
{
    public int minSteps(String s, String t)
    {

        int[] arr = new int[126];
        for (int i = 0; i < s.length(); i++)
        {
            arr[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++)
        {
            arr[t.charAt(i)]--;
        }
        int changes = 0;
        for (int i = 0; i < arr.length; i++)
        {
            changes += Math.abs(arr[i]);
        }

        return changes / 2;
    }
}
