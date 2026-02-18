class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int q = queries.length;
        int[][] indexedQueries = new int[q][2];
        int[] res = new int[q];

        for (int i = 0; i < q; i++) {
            indexedQueries[i][0] = queries[i] - x;
            indexedQueries[i][1] = i;
        }

        Arrays.sort(indexedQueries, (a, b) -> a[0] - b[0]);
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        Map<Integer, Integer> freqMap = new HashMap<>();

        int left = 0;
        int right = 0;

        for (int[] query : indexedQueries) {
            int curStart = query[0];
            int curEnd = curStart + x;
            int index = query[1];

            while (right < logs.length && logs[right][1] <= curEnd) {
                freqMap.merge(logs[right][0], 1, Integer::sum);
                right++;
            }

            while (left < logs.length && logs[left][1] < curStart) {
                freqMap.merge(logs[left][0], -1, Integer::sum);
                if (freqMap.get(logs[left][0]) == 0) {
                    freqMap.remove(logs[left][0]);
                }
                left++;
            }

            res[index] = n - freqMap.size();
        }

        return res;
    
    }
}