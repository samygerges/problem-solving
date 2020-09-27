package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class EvaluateDivision {

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		if (equations == null || equations.isEmpty() || queries == null || queries.isEmpty()) {
			return new double[] {};
		}

		double[] res = new double[queries.size()];
		Map<String, List<Pair<Pair<String, String>, Double>>> map = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			map.putIfAbsent(equations.get(i).get(0), new ArrayList<>());
			map.putIfAbsent(equations.get(i).get(1), new ArrayList<>());
			map.get(equations.get(i).get(0))
					.add(new Pair<>(new Pair<>(equations.get(i).get(0), equations.get(i).get(1)), values[i]));
			map.get(equations.get(i).get(1))
					.add(new Pair<>(new Pair<>(equations.get(i).get(1), equations.get(i).get(0)), 1 / values[i]));
		}

		for (int i = 0; i < queries.size(); i++) {
			if (map.containsKey(queries.get(i).get(0)) && map.containsKey(queries.get(i).get(1))) {
				res[i] = dfs(map, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), 1);
			} else {
				res[i] = -1.0;
			}
		}
		return res;
	}

	private double dfs(Map<String, List<Pair<Pair<String, String>, Double>>> map, String from, String to,
			HashSet<String> visited, double value) {
		if (from.equals(to)) {
			return value;
		}
		visited.add(from);
		for (Pair<Pair<String, String>, Double> node : map.get(from)) {
			if (visited.contains(node.getKey().getValue())) {
				continue;
			}
			double res = dfs(map, node.getKey().getValue(), to, visited, value * node.getValue());
			if (res != -1) {
				return res;
			}
		}
		return -1;
	}
}
