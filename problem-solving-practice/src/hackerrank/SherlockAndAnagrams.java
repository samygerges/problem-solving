package hackerrank;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams
{
    static int sherlockAndAnagrams(String s)
    {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i + 1; j <= s.length(); j++)
            {
                String sub = s.substring(i, j);
                char[] arr = sub.toCharArray();
                Arrays.sort(arr);
                sub = String.valueOf(arr);
                int count = map.getOrDefault(sub, 0);
                if (count > 0)
                {
                    result += count;
                }
                map.put(sub, count + 1);
            }
        }

        return result;
    }
}
