package leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class CheapestFlights {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		Set<Node> visited = new HashSet<>();
		Map<Integer, Node> graph = new HashMap<>();

		for (int i = 0; i < flights.length; i++) {
			Node node = new Node();
			node.src = flights[i][0];
			graph.put(node.src, node);

			Node node2 = new Node();
			node2.src = flights[i][1];
			graph.put(node2.src, node2);
		}

		for (int i = 0; i < flights.length; i++) {
			Node node = graph.get(flights[i][0]);
			node.neighbours.put(graph.get(flights[i][1]), flights[i][2]);
			node.stops.put(graph.get(flights[i][1]), -1);
			if (node.src == src)
				node.cost = 0;
		}

		queue.add(graph.get(src));

		int minCost = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Node node = queue.remove();
			for (Node tmp : node.neighbours.keySet()) {
				if (!visited.contains(tmp) || tmp.cost > node.cost) {
					tmp.cost = Math.min(tmp.cost, node.cost + node.neighbours.get(tmp));
					node.stops.put(tmp, node.stops.get(tmp) + 1);
					tmp.stops = node.stops;
					if (tmp.src == dst) {
						if (minCost > node.cost && node.stops.get(tmp) <= K)
							minCost = node.cost + node.neighbours.get(tmp);
					} else {
						queue.add(tmp);
					}
				}
			}
			visited.add(node);
		}

		return minCost == Integer.MAX_VALUE ? -1 : minCost;
	}

	class Node implements Comparable<Node> {
		int src;
		int cost = Integer.MAX_VALUE;
		Map<Node, Integer> neighbours = new HashMap<>();
		Map<Node, Integer> stops = new HashMap<>();

		@Override
		public int compareTo(Node o) {
			if (cost < o.cost)
				return 1;
			if (cost > o.cost)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) {
		CheapestFlights a = new CheapestFlights();
		System.out
				.println(a.findCheapestPrice(5, new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, 0, 2, 0));
	}
}
