class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);

        dfs(res, 0, graph, path);

        return res;
    }

    private void dfs(List<List<Integer>> res, int node, int[][] graph, List<Integer> path) {

        if(node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int nei : graph[node]) {
            path.add(nei);

            dfs(res, nei, graph, path);

            path.remove(path.size() - 1);
        } 
    }
}