class Solution {
       private int[][] rects;
    private int[] prefixSums;
    private Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.rand = new Random();

        prefixSums = new int[rects.length];
        int sum = 0;
        for (int i = 0; i < rects.length; i++) {
            int a = rects[i][0], b = rects[i][1], x = rects[i][2], y = rects[i][3];
            int count = (x - a + 1) * (y - b + 1);
            sum += count;
            prefixSums[i] = sum;
        
    }
    }
    public int[] pick() {
        int totalPoints = prefixSums[prefixSums.length - 1];
        int target = rand.nextInt(totalPoints) + 1; // 1-based

        // Step 2: binary search to find rectangle
        int rectIndex = Arrays.binarySearch(prefixSums, target);
        if (rectIndex < 0) rectIndex = -rectIndex - 1;

        int[] rect = rects[rectIndex];
        int a = rect[0], b = rect[1], x = rect[2], y = rect[3];

        // Step 3: pick random point inside rectangle
        int randX = a + rand.nextInt(x - a + 1);
        int randY = b + rand.nextInt(y - b + 1);

        return new int[]{randX, randY};

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */