package hackerrank;
import java.util.Arrays;

public class CavityMap
{
    public static void main(String[] args)
    {
        String[] res = cavityMap(new String[] {"989", "191", "111"});
        Arrays.stream(res).forEach(System.out::println);
    }


    static String[] cavityMap(String[] grid)
    {
        int[][] arr = new int[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length(); j++)
            {
                arr[i][j] = Integer.parseInt("" + grid[i].charAt(j));
            }
        }

        String[] result = new String[grid.length];
        for (int i = 0; i < arr.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr[i].length; j++)
            {
                if (i == 0 || j == 0 || i + 1 == arr.length || j + 1 == arr[i].length)
                {
                    sb.append(arr[i][j]);
                }
                else
                {
                    if (arr[i][j] > arr[i - 1][j] && arr[i][j] > arr[i + 1][j] && arr[i][j] > arr[i][j - 1] && arr[i][j] > arr[i][j + 1])
                    {
                        sb.append('X');
                    }
                    else
                    {
                        sb.append(arr[i][j]);
                    }
                }
            }
            result[i] = sb.toString();
        }
        return result;
    }
}
