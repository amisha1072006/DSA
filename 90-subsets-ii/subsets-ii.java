class Solution {
        private List<List<Integer>> output=new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
             Arrays.sort(nums);
        backtrack(new ArrayList<>(),nums,0);
        return output;
    }
    void backtrack(List<Integer> cur,int[] nums,int index){
        output.add(new ArrayList<>(cur));
        for(int i=index;i<nums.length;i++){
            cur.add(nums[i]);
            backtrack(cur,nums,i+1);
            while(i+1<nums.length && nums[i]==nums[i+1]){
                i++;
            }
            cur.remove(cur.size()-1);
        }   
    }
}