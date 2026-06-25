class Solution {
    public int makeConnected(int n, int[][] connections) {
                if (connections.length < n - 1) return -1;  // Not enough edges to connect all computers
        
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        
        // Build the graph (adjacency list)
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : connections) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int components = 0;
        
        // Perform DFS to count the number of connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, graph, visited);
            }
        }
        
        // If the number of extra cables is sufficient to connect all components
        return components - 1;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}