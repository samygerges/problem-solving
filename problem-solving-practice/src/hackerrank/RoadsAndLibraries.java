package hackerrank;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class RoadsAndLibraries
{
	static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities)
	{
		long cost = 0;
		Map<Integer, Set<Integer>> fixed = new HashMap<>();
		Set<Integer> fixedRoads = new HashSet<>();
		boolean[][] roads = new boolean[n + 1][n + 1];
		Set<Integer> libs = new HashSet<>();
		Set<Integer> citiesNum = new HashSet<>();
		for (int i = 1; i <= n; i++)
		{
			citiesNum.add(i);
		}

		for (int[] i : cities)
		{
			if (!canReach(n, i[0], i[1], fixed))
			{
				cost += c_road;
				fixed.putIfAbsent(i[0], new HashSet<>());
				fixed.get(i[0]).add(i[1]);
				fixed.putIfAbsent(i[1], new HashSet<>());
				fixed.get(i[1]).add(i[0]);
			}
		}

		for (int[] i : cities)
		{
			roads[i[0]][i[1]] = true;
			roads[i[1]][i[0]] = true;
		}

//		for (int i = 1; i <= n; i++)
//		{
//			if (!fixedRoads.contains(i))
//			{
//				fixedRoads.add(i);
//				cost += c_road;
//				for (int j = 1; j <= n; j++)
//				{
//					if (roads[i][j])
//					{
//						fixedRoads.add(j);
//					}
//				}
//			}
//		}

		for (int i = 1; i <= n; i++)
		{
			boolean canReachLib = false;
			for (int j = 1; j <= n; j++)
			{
				if (roads[i][j] && libs.contains(j))
				{
					canReachLib = true;
					break;
				}
			}
			if (!canReachLib)
			{
				libs.add(i);
				cost += c_lib;
			}
		}

		return Math.min(cost, n * c_lib);
	}

	private static boolean canReach(int n, int source, int dest, Map<Integer, Set<Integer>> fixed)
	{
		boolean[] visited = new boolean[n + 1];
		Stack<Integer> stack = new Stack<>();
		if (fixed.containsKey(source))
		{
			stack.addAll(fixed.get(source));
		}
		while (!stack.isEmpty())
		{
			int current = stack.pop();
			visited[current] = true;
			if (fixed.containsKey(current) && fixed.get(current).contains(dest))
			{
				return true;
			}
			else if (fixed.containsKey(current))
			{
				for (int i : fixed.get(current))
				{
					if (!visited[i])
					{
						stack.push(i);
					}
				}
			}
		}
		return false;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++)
		{
			String[] nmC_libC_road = scanner.nextLine().split(" ");
			int n = Integer.parseInt(nmC_libC_road[0]);
			int m = Integer.parseInt(nmC_libC_road[1]);
			int c_lib = Integer.parseInt(nmC_libC_road[2]);
			int c_road = Integer.parseInt(nmC_libC_road[3]);
			int[][] cities = new int[m][2];

			for (int i = 0; i < m; i++)
			{
				String[] citiesRowItems = scanner.nextLine().split(" ");
				//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int j = 0; j < 2; j++)
				{
					int citiesItem = Integer.parseInt(citiesRowItems[j]);
					cities[i][j] = citiesItem;
				}
			}

			long result = roadsAndLibraries(n, c_lib, c_road, cities);
			System.out.println(result);
		}
		scanner.close();
	}
}
