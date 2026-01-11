class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
             int cnt = 0;

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 1; i <= arrivals.length; i++) {
            int type = arrivals[i - 1];
            int window = Math.max(1, i - w + 1);

            PriorityQueue<Integer> q = map.computeIfAbsent(type, k -> new PriorityQueue<>());

            // Remove expired arrivals outside of window
            while (!q.isEmpty() && q.peek() < window) {
                q.poll();
            }

            // If within limit, accept; else discard
            if (q.size() < m) {
                q.offer(i);
            } else {
                cnt++;
            }
        }
        return cnt;
       
    }
}