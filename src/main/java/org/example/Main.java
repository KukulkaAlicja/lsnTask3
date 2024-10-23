package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<Integer>> graphs = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int connectedElements = 0;

        System.out.println("Task 3");
        System.out.println("Please enter input numbers of edges");

        int numberOfEdges = scanner.nextInt();
        for (int i = 0; i < numberOfEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graphs.putIfAbsent(u, new ArrayList<>());
            graphs.putIfAbsent(v, new ArrayList<>());
            graphs.get(u).add(v);
            graphs.get(v).add(u);
        }

        for (int vertex : graphs.keySet()) {
            if (!visited.contains(vertex)) {
                dfs(graphs, visited, vertex);
                connectedElements++;
            }
        }

        System.out.println(connectedElements);
        scanner.close();
    }

    private static void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int vertex) {
        visited.add(vertex);
        for (int neighbor : graph.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}