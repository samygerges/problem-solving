import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WeightedUniformStrings
{
    public static void main(String[] args)
    {
        Arrays.stream(weightedUniformStrings("abccddde", new int[] {1, 3, 12, 5, 9, 10})).forEach(System.out::println);
    }


    static String[] weightedUniformStrings(String s, int[] queries)
    {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int count = 1;
            set.add(count * (c - 'a' + 1));
            int j;
            for (j = i + 1; j < s.length(); j++)
            {
                if (s.charAt(j) == c)
                {
                    set.add(++count * (c - 'a' + 1));
                }
                else
                    break;
            }
            i = j - 1;
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++)
        {
            if (set.contains(queries[i]))
            {
                result[i] = "Yes";
            }
            else
            {
                result[i] = "No";
            }
        }
        return result;
    }
}
