package hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DijkstraShortestReach2
{
	static int[] shortestReach(int n, int[][] edges, int s)
	{
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 0; i < edges.length; i++)
		{
			graph[edges[i][0]][edges[i][1]] = edges[i][2];
			graph[edges[i][1]][edges[i][0]] = edges[i][2];
		}
		int[] dist = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[s] = 0;
		for (int i = 1; i < n; i++)
		{
			int u = minDistance(n, dist, visited);
			visited[u] = true;
			for (int v = 1; v <= n; v++)
			{
				if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && graph[u][v] + dist[u] < dist[v])
				{
					dist[v] = graph[u][v] + dist[u];
				}
			}
		}
		int[] res = new int[n - 1];
		int index = 0;
		for (int i = 1; i <= n; i++)
		{
			if (i == s)
			{
				continue;
			}
			if (dist[i] == Integer.MAX_VALUE)
			{
				res[index++] = -1;
			}
			else
			{
				res[index++] = dist[i];
			}
		}
		return res;
	}

	static int minDistance(int n, int dist[], boolean visited[])
	{
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 1; v <= n; v++)
		{
			if (!visited[v] && dist[v] <= min)
			{
				min = dist[v];
				min_index = v;
			}
		}

		return min_index;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++)
		{
			String[] nm = scanner.nextLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			int[][] edges = new int[m][3];
			for (int i = 0; i < m; i++)
			{
				String[] edgesRowItems = scanner.nextLine().split(" ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int j = 0; j < 3; j++)
				{
					int edgesItem = Integer.parseInt(edgesRowItems[j]);
					edges[i][j] = edgesItem;
				}
			}

			int s = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] result = shortestReach(n, edges, s);

			for (int i = 0; i < result.length; i++)
			{
				System.out.print(String.valueOf(result[i]));
				if (i != result.length - 1)
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		scanner.close();
	}
}
