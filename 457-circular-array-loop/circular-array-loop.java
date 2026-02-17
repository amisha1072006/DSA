class Solution {
    public boolean circularArrayLoop(int[] nums) {
                final int limit = 1000;
        int visitedForward = limit;
        int visitedBackward = -limit;
        
        for(int i = 0; i< nums.length; i++) {
            if(isVisited(nums[i], limit)) // already visited
                continue;
            
            boolean isForward = nums[i] > 0;
            int nextPos = i;
            int visitFlag = isForward ? ++visitedForward : --visitedBackward; 
            //keep the sign in the flag to know the direction
            
            do {
                nextPos = getNextPos(nums, nextPos, isForward, visitFlag);
            } while (nextPos > -1 && 
                     nextPos != i && 
                     !isVisited(nums[nextPos], limit));
            
            if(nextPos > -1 && (nextPos == i || nums[nextPos] == visitFlag))
                return true;
        }
        
        return false;
    }
    
    private boolean isVisited (int val, int limit) {
        return Math.abs(val) > limit;
    }
    
    // return -1 if invalid pos
    private int getNextPos(int[] nums, int i, boolean isForward, int visitFlag) {
        boolean direction = nums[i] > 0;
        
        if(direction != isForward) 
            return -1;
        
        int next = (i + nums[i]) % nums.length;
        
        if (next < 0) 
            next += nums.length; // in case it's negative counterbalance with the array size to know the real position
        
        nums[i] = visitFlag;
        
        return next == i ? -1 : next;

    }
}