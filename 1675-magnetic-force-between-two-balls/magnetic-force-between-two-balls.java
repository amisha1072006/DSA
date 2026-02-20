import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
                Arrays.sort(position);  // Step 1: Sort the basket positions
        
        int start = 1;  // Minimum possible distance
        int end = (position[position.length - 1] - position[0]) / (m - 1);  // Maximum possible distance
        
        // Step 2-4: Binary search on the distance
        while (start <= end) {
            int mid = (end + start) / 2;  // Midpoint of the current search space
            if (canPlaceBalls(position, mid, m)) {
                start = mid + 1;  // If placing m balls with at least 'mid' distance is possible, try for a larger distance
            } else {
                end = mid - 1;  // Otherwise, try for a smaller distance
            }
        }
        
        return end;  // Step 5: The largest possible minimum distance
    }
    
    // Helper function to check if placing m balls with at least 'mid' distance is possible
    private boolean canPlaceBalls(int[] position, int mid, int m) {
        int count = 1;  // Place the first ball
        int lastPosition = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= mid) {
                count++;
                lastPosition = position[i];
                if (count == m) {
                    return true;  // All m balls placed successfully
                }
            }
        }
        
        return false;  // Not possible to place all m balls
   
    }
}