class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int count = 0;
        int[] ans = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());

        // Build adjacency list: b -> a
        for (int[] i : prerequisites)
            adjList.get(i[1]).addLast(i[0]);

        Queue<Integer> q = new ArrayDeque<>();

        int[] indegree = new int[numCourses];
        for (int[] e : prerequisites)
            indegree[e[0]]++;  // a depends on b

        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            Integer node = q.poll();

            for (int adjNodes : adjList.get(node)) {
                indegree[adjNodes]--;
                if (indegree[adjNodes] == 0)
                    q.add(adjNodes);
            }
            ans[count++] = node;
        }

        if (count != numCourses) return new int[]{};  // cycle found

        return ans;
    
    }
}