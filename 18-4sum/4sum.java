class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      Arrays.sort(nums);
        if(target<0&&nums[0]>0){
            return new ArrayList<>();
        }
        List<List<Integer>> list=new ArrayList<>();
        long sum=0;
        for(int i=0;i<nums.length-3;i++){
                if(i>0&&nums[i]==nums[i-1])continue;

            for(int j=i+1;j<nums.length-2;j++){
                     if(j>i+1 &&nums[j]==nums[j-1])continue;

                int start=j+1;
                int end=nums.length-1;
                while(start<end){

                    sum=nums[i]+nums[j]+nums[start]+nums[end];

                    if(sum==target){

                    list.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));

                    while(start<end&&nums[start]==nums[start+1]) start++;
                    while(start<end&&nums[end]==nums[end-1])end--;

                    start++;

                    end--;

                    }else if(sum>target){
                        end--;

                    }else{
                        start++;
                    }
                }
            }
        }
        return list;
  
    }
}