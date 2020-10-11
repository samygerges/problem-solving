package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BreadthFirstSearchShortestPath
{
	static int[] bfs(int n, int m, int[][] edges, int s)
	{
		Map<Integer, Set<Integer>> map = new HashMap<>();
		boolean[] visited = new boolean[n];
		for (int[] i : edges)
		{
			map.putIfAbsent(i[0], new HashSet<>());
			map.putIfAbsent(i[1], new HashSet<>());
			map.get(i[0]).add(i[1]);
			map.get(i[1]).add(i[0]);
		}
		int[] calc = new int[n];
		Queue<Set<Integer>> queue = new LinkedList<>();
		if (map.containsKey(s))
		{
			queue.add(map.get(s));
		}
		int loop = 1;
		while (!queue.isEmpty())
		{
			Set<Integer> next = queue.remove();
			Set<Integer> nodes = new HashSet<>();
			for (int i : next)
			{
				if (!visited[i - 1])
				{
					calc[i - 1] = loop;
					visited[i - 1] = true;
					if (map.containsKey(i))
					{
						nodes.addAll(map.get(i));
					}
				}
			}
			if (!nodes.isEmpty())
			{
				queue.add(nodes);
			}
			loop++;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++)
		{
			if (i == s - 1)
			{
				continue;
			}
			else if (calc[i] == 0)
			{
				list.add(-1);
			}
			else
			{
				list.add(calc[i] * 6);
			}
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++)
		{
			String[] nm = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nm[0]);

			int m = Integer.parseInt(nm[1]);

			int[][] edges = new int[m][2];

			for (int i = 0; i < m; i++)
			{
				String[] edgesRowItems = scanner.nextLine().split(" ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int j = 0; j < 2; j++)
				{
					int edgesItem = Integer.parseInt(edgesRowItems[j]);
					edges[i][j] = edgesItem;
				}
			}

			int s = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] result = bfs(n, m, edges, s);

			for (int i = 0; i < result.length; i++)
			{
				System.out.print(result[i]);
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
