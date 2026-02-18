class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
              Arrays.sort(tiles, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = tiles.length;
        // prefix sum of white tiles up to index i
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (tiles[i][1] - tiles[i][0] + 1);
        }
        
        int result = 0;
        int j = 0;
        
        // Step 2: Sliding window
        for (int i = 0; i < n; i++) {
            // Carpet starts at tiles[i][0], ends at:
            long end = (long) tiles[i][0] + carpetLen - 1;
            
            // Move j forward until tiles[j][1] > end
            while (j < n && tiles[j][1] <= end) {
                j++;
            }
            
            // Step 3: Compute coverage
            int covered = (int)(prefix[j] - prefix[i]);
            
            // Partial overlap with tiles[j] (if any)
            if (j < n && tiles[j][0] <= end) {
                covered += (int)(end - tiles[j][0] + 1);
            }
            
            result = Math.max(result, covered);
        }
        
        return result;
  
    }
}