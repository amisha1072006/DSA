class Solution {
    public int maxRectangleArea(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int[] p: points) set.add(Arrays.toString(p));
        int maxArea = -1;

        for (int i = 0; i < points.length; i++) {
            for (int j = 1; j < points.length; j++) {
                int[] p1 = points[i], p2 = points[j];
                if (p1[0] == p2[0] 
                 || p1[1] == p2[1] 
                 || !set.contains(Arrays.toString(new int[]{p1[0], p2[1]})) 
                 || !set.contains(Arrays.toString(new int[]{p2[0], p1[1]}))
                 || !validate(points, p1, p2)) continue;

                // update area 
                maxArea = Math.max(maxArea, (p2[1] - p1[1]) * (p2[0] - p1[0]));
            }
        }
        return maxArea;
    }
        private boolean validate(int[][] points, int[] p1, int[] p2) {
        int top = Math.max(p1[1], p2[1]), bot = Math.min(p1[1], p2[1]);
        int left = Math.min(p1[0], p2[0]), right = Math.max(p1[0], p2[0]);

        for (int[] p: points) {
            int x = p[0], y = p[1];

             // check top/bot
            if (((y == top || y == bot) && x > left && x < right)
             // check left/right
             || ((x == left || x == right) && y > bot && y < top)
             // check inside
             || (x > left && x < right && y > bot && y < top)) return false;
        }
        return true;
    
    }
}