package hackerrank;
import java.util.ArrayList;
import java.util.List;

public class KaprekarNumbers
{
    public static void main(String[] args)
    {
        kaprekarNumbers(1, 99999);
    }


    static void kaprekarNumbers(int p, int q)
    {
        List<Integer> kaprekars = new ArrayList<>();
        for (int i = p; i <= q; i++)
        {
            if (isKaprekar(i))
            {
                kaprekars.add(i);
            }
        }

        if (kaprekars.isEmpty())
        {
            System.out.println("INVALID RANGE");
        }
        else
        {
            for (int i = 0; i < kaprekars.size(); i++)
            {
                System.out.print(kaprekars.get(i));
                if (i + 1 < kaprekars.size())
                {
                    System.out.print(" ");
                }
            }
        }
    }


    private static boolean isKaprekar(int num)
    {
        long square = (long) Math.pow(num, 2);
        String s = "" + square;
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);

        s1 = s1.isEmpty() ? "0" : s1;
        s2 = s2.isEmpty() ? "0" : s2;

        return Integer.parseInt(s1) + Integer.parseInt(s2) == num;
    }
}
