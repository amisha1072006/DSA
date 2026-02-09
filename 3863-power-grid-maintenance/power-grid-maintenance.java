class Solution {
        private int[] parent;
    private int[] size;
    private boolean[] isOnline;
    private TreeSet<Integer>[] onlineSets;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
                int n = c;
        parent = new int[n + 1];
        size = new int[n + 1];
        isOnline = new boolean[n + 1];
        onlineSets = new TreeSet[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
            isOnline[i] = true;
            onlineSets[i] = new TreeSet<>();
            onlineSets[i].add(i);
        }

        for (int[] conn : connections) {
            union(conn[0], conn[1]);
        }

        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];

            if (type == 1) {
                if (isOnline[x]) {
                    result.add(x);
                } else {
                    int root = find(x);
                    if (onlineSets[root].isEmpty()) {
                        result.add(-1);
                    } else {
                        result.add(onlineSets[root].first());
                    }
                }
            } else {
                if (isOnline[x]) {
                    isOnline[x] = false;
                    int root = find(x);
                    onlineSets[root].remove(x);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int u, int v) {
        int ru = find(u);
        int rv = find(v);
        if (ru == rv) return;

        if (size[ru] < size[rv]) {
            int temp = ru;
            ru = rv;
            rv = temp;
        }

        for (int station : onlineSets[rv]) {
            onlineSets[ru].add(station);
        }
        onlineSets[rv].clear();

        parent[rv] = ru;
        size[ru] += size[rv];

    }
}