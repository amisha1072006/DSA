class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int val:nums)map.put(val,map.getOrDefault(val,0)+1);
        int max=0;
        for(int val:map.keySet()){
            max=Math.max(max,map.get(val)+map.getOrDefault((val+1),-map.get(val)));
        }
        return max;
    }
}