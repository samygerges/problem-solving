package hackerrank;

public class ChocolateFeast
{
    public static void main(String[] args)
    {
        System.out.println(chocolateFeast(6, 2, 2));
    }


    static int chocolateFeast(int n, int c, int m)
    {
        int eaten = 0;
        int wrappers = 0;
        for (int i = n - c; i >= 0; i -= c)
        {
            eaten++;
            wrappers++;
            if (wrappers == m)
            {
                i += c;
                wrappers = 0;
            }
        }
        return eaten;
    }

}
