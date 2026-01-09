class Solution {
    Map<Integer,List<Integer>>map;
    public Solution(int[] nums) {
               this.map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
     
    }
    
    public int pick(int target) {
             int n=map.get(target).size();
        return map.get(target).get((int)(Math.random()*n));
       
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */