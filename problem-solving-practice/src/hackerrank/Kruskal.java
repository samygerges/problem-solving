package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Kruskal
{
	public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight)
	{
		int[][] graph = new int[gNodes + 1][gNodes + 1];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < gFrom.size(); i++)
		{
			graph[gFrom.get(i)][gTo.get(i)] = gWeight.get(i);
			graph[gTo.get(i)][gFrom.get(i)] = gWeight.get(i);
		}
		for (int i = 1; i < graph.length; i++)
		{
			boolean[] visited = new boolean[gNodes + 1];
			visited[i] = true;
			min = Math.min(min, dfs(graph, visited, i, 1, 0));
		}
		return min;
	}

	private static Integer dfs(int[][] graph, boolean[] visited, int start, int count, int weight)
	{
		if (count == visited.length - 1)
		{
			return weight;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < graph.length; i++)
		{
			if (graph[start][i] > 0 && !visited[i])
			{
				visited[i] = true;
				weight += graph[start][i];
				min = Math.min(min, Math.min(dfs(graph, visited, start, count + 1, weight), dfs(graph, visited, i, count + 1, weight)));
				visited[i] = false;
				weight -= graph[start][i];
			}
		}
		return min;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int gNodes = Integer.parseInt(gNodesEdges[0]);
		int gEdges = Integer.parseInt(gNodesEdges[1]);

		List<Integer> gFrom = new ArrayList<>();
		List<Integer> gTo = new ArrayList<>();
		List<Integer> gWeight = new ArrayList<>();

		IntStream.range(0, gEdges).forEach(i -> {
			try
			{
				String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				gFrom.add(Integer.parseInt(gFromToWeight[0]));
				gTo.add(Integer.parseInt(gFromToWeight[1]));
				gWeight.add(Integer.parseInt(gFromToWeight[2]));
			}
			catch (IOException ex)
			{
				throw new RuntimeException(ex);
			}
		});

		int res = kruskals(gNodes, gFrom, gTo, gWeight);

		System.out.println(res);

		bufferedReader.close();
	}
}
