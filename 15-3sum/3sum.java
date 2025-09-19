class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    set.add(list);
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                }
                else{
                    k--;
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> x : set){
            ans.add(x);
        }
        return ans;

    }
}