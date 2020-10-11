package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class FloydCityOfBlindingLights
{
	public static int shortestPath(int n, int[] roadFrom, int[] roadTo, int[] roadWeight, int start, int end) {
		int[][] graph = new int[n + 1][n + 1];
		for(int i = 0; i < roadFrom.length; i++) {
			graph[roadFrom[i]][roadTo[i]] = roadWeight[i];
		}

		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		for(int i = 1; i < n; i++) {
			int u = getMinDistance(n, dist, visited);
			if(u != -1) {
				visited[u] = true;
				for(int v = 1; v <= n; v++) {
					if(!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && graph[u][v] + dist[u] < dist[v])
					{
						dist[v] = graph[u][v] + dist[u];
					}
				}
			}
		}

		return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
	}

	private static int getMinDistance(int n, int[] dist, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int index = -1;

		for(int i = 1; i <= n; i++) {
			if(!visited[i] && dist[i] <= min) {
				min = dist[i];
				index = i;
			}
		}

		return index;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] roadNodesEdges = scanner.nextLine().split(" ");
		int roadNodes = Integer.parseInt(roadNodesEdges[0].trim());
		int roadEdges = Integer.parseInt(roadNodesEdges[1].trim());

		int[] roadFrom = new int[roadEdges];
		int[] roadTo = new int[roadEdges];
		int[] roadWeight = new int[roadEdges];

		for (int i = 0; i < roadEdges; i++) {
			String[] roadFromToWeight = scanner.nextLine().split(" ");
			roadFrom[i] = Integer.parseInt(roadFromToWeight[0].trim());
			roadTo[i] = Integer.parseInt(roadFromToWeight[1].trim());
			roadWeight[i] = Integer.parseInt(roadFromToWeight[2].trim());
		}

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] xy = scanner.nextLine().split(" ");

			int x = Integer.parseInt(xy[0]);

			int y = Integer.parseInt(xy[1]);

			int output = shortestPath(roadNodes, roadFrom, roadTo, roadWeight, x, y);
			System.out.println(output);
		}

		scanner.close();
	}
}
