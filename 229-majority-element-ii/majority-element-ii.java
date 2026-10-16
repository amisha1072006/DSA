class Solution {
    public List<Integer> majorityElement(int[] nums) {
     // BRUTE FORCE APPROACH
     //TC = O(n*2), SC = O(1)
     int n = nums.length;
      int freq = n/3;
      List<Integer> list = new ArrayList<>();
      Arrays.sort(nums);
      for(int i = 0; i<n; i++){
        int count = 1;
        if(i> 0 && nums[i] == nums[i-1]){
            continue;
        }
        for(int j = i+1; j<n; j++){
           if(nums[i] == nums[j]){
            count++;
           }
        }
        if(count>freq){
            list.add(nums[i]);
        }
      }
      return list;

        //BETTER APPROACH 
        // TC = O(nlogn), SC = O(1)
    //   int n = nums.length;
    //   int freq = n/3;
    //   int count = 1;
    //   List<Integer> list = new ArrayList<>();
    //   Arrays.sort(nums);
    //   for(int i = 0; i<n-1; i++){
    //        if(nums[i] == nums[i+1]){
    //         count++;
    //        }
    //        else{
    //         count = 1;
    //        }
    //     if(count>freq){
    //         if(list.size() == 0 || list.get(list.size()-1) != nums[i]){
    //         list.add(nums[i]);
    //     }
    //     }
    //   }
    //     if(count>freq){
    //         if(list.size() == 0 || list.get(list.size()-1) != nums[n-1]){
    //         list.add(nums[n-1]);
    //     }
    //     }
    //   return list;


    //   TreeMap<Integer, Integer> map = new HashMap<>();
    //   List<Integer> list = new ArrayList<>();
    //   Arrays.sort(nums);
    //   for(int i = 0; i<n; i++){
    //     if(map.containskey(nums[i] && map.get))
    //   }
       
    //   return list;
}
}