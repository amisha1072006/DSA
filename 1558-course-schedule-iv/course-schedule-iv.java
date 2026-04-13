class Solution {
        private List<Integer>[] adj;
    private int[][] memo;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
       adj = new ArrayList[numCourses];
        memo = new int[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
            Arrays.fill(memo[i], -1);
        }

        for (int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
            memo[pre[1]][pre[0]] = 1;
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(dfs(query[1], query[0]));
        }

        return result;
    }

    private boolean dfs(int curr, int target) {
        if (memo[curr][target] != -1) {
            return memo[curr][target] == 1;
        }
        for (int next : adj[curr]) {
            if (next == target || dfs(next, target)) {
                memo[next][target] = 1;
                return true;
            }
        }
        memo[curr][target] = 0;
        return false;
 
    }
}