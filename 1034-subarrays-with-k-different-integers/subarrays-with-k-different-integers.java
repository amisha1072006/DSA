class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
                return fn(nums, k) - fn(nums, k - 1);
    }

    public int fn(int arr[], int k) {

        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int c = 0;
        while (j < n) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            while (map.size() > k) {
                map.put(arr[i], map.get(arr[i]) - 1);

                if (map.get(arr[i]) == 0) {
                    map.remove(arr[i]);
                }
                i++;
            }

            c += j-i+1;
            j++;
        }
        return c;
    
    }
}