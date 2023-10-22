class Solution {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> graph = buildGraph(equations, values);
		double[] results = new double[queries.size()];

		for (int i = 0; i < queries.size(); i++) {
			results[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashMap<>());
		}

		return results;
	}

	private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
		Map<String, Map<String, Double>> graph = new HashMap<>();

		for (int i = 0; i < equations.size(); i++) {
			String from = equations.get(i).get(0);
			String to = equations.get(i).get(1);
			double value = values[i];

			graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, value);
			graph.computeIfAbsent(to, k -> new HashMap<>()).put(from, 1 / value);
		}

		return graph;
	}

	private double dfs(Map<String, Map<String, Double>> graph, String from, String to, Map<String, Boolean> visited) {
		if (!graph.containsKey(from) || !graph.containsKey(to)) {
			return -1.0;
		}

		if (from.equals(to)) {
			return 1.0;
		}

		visited.put(from, true);

		for (Map.Entry<String, Double> neighbor : graph.get(from).entrySet()) {
			if (!visited.containsKey(neighbor.getKey()) || !visited.get(neighbor.getKey())) {
				double result = dfs(graph, neighbor.getKey(), to, visited);
				if (result != -1.0) {
					return result * neighbor.getValue();
				}
			}
		}

		visited.put(from, false);
		return -1.0;
	}
}
