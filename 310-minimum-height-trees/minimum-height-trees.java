class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
                List<Integer> ans = new ArrayList<>();
        
        if (n == 1) {
            ans.add(0);
            return ans;
        }

        // Step 1: Build adjacency list and indegree array
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        // Step 2: Add all leaf nodes to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }

        // Step 3: Remove leaves level by level
        while (n > 2) {
            int size = q.size();
            n -= size;  // Reduce count of nodes left in the graph
            
            for (int i = 0; i < size; i++) {
                int leaf = q.poll();
                for (int neighbor : adj.get(leaf)) {
                    indegree[neighbor]--;  // Reduce indegree
                    if (indegree[neighbor] == 1) {
                        q.offer(neighbor);  // Add new leaves
                    }
                }
            }
        }
        // Remaining nodes are the roots of MHT
        ans.addAll(q);
        return ans;
    
    }
}