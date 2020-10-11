package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CoinChange
{
	public static long getWays(int n, List<Integer> c)
	{
		long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < c.size(); i++)
        {
            for (int j = c.get(i); j <= n; j++)
            {
                dp[j] += dp[j - c.get(i)];
            }
        }

        return dp[n];
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		int n = Integer.parseInt(firstMultipleInput[0]);
		int m = Integer.parseInt(firstMultipleInput[1]);
		List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());
		// Print the number of ways of making change for 'n' units using coins having the values given by 'c'
		long ways = getWays(n, c);
		System.out.println(ways);
		bufferedReader.close();
	}
}
