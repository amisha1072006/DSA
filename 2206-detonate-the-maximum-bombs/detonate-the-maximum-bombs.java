class Solution {
    public int maximumDetonation(int[][] bombs) {
                Arrays.sort(bombs, (o1, o2) -> o2[2] - o1[2]);
        int res = 0;
        for (int i = 0; i < bombs.length; i++) {
            int[][] copy = Arrays.copyOf(bombs, bombs.length);
            int count = 1;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(copy[i]);
            copy[i] = null;
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                int y = arr[1], x = arr[0], r = arr[2];
                for (int j = 0; j < copy.length; j++) {
                    int[] b = copy[j];
                    if (b == null) continue;
                    int y1 = b[1], x1 = b[0], r1 = b[2];
                    double dist = Math.sqrt(Math.pow(y - y1, 2) + Math.pow(x - x1, 2));
                    if (dist <= r) {
                        count++;
                        queue.offer(b);
                        copy[j] = null;
                    }
                }
            }
            res = Math.max(count, res);
        }
        return res;

    }
}