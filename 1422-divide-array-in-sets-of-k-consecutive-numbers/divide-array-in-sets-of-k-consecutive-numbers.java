class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
                int n = nums.length;
        if (n % k != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        while (!map.isEmpty()) {
            int cnt = k;
            int curr = map.firstKey();
            // System.out.println(map);
            // System.out.println(curr);
            while (cnt > 0) {
                if (!map.containsKey(curr)) {
                    return false;
                }
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0) {
                    map.remove(curr);
                }
                cnt--;
                curr++;
            }
        }
        return true;
    
    }
}