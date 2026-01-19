class Solution {
    private List<Integer> list;
    public int minMoves(int[] nums, int k) {
               if(nums.length == k) return 0;
        int Le = 0, Re = 0, mid, L = 0, R = 0, cost, minCost = Integer.MAX_VALUE, j;
        list = new ArrayList<>();
        for(int i = 0; i<nums.length; ++i){
            if(nums[i] == 1){
                list.add(i);
            }
        }
        int n = list.size(), prevMid;
        mid = 0 + ((k-1)-0)/2;
        Le = mid; Re = k-mid-1;
        for(int i = 0; i < mid; ++i){
            L += (list.get(mid) - list.get(i)) - (mid-i);
        }
        for(int i = mid + 1; i < k; ++i){
            R += (list.get(i) - list.get(mid)) - (i-mid);
        }
        minCost = L + R;
        
        for(int i = 1; i <= n-k; ++i){
            j = i + k - 1;
            prevMid = mid;
            mid = mid + 1;
            L = L - cost(i-1, prevMid) + Le * cost(prevMid, mid);

            R = R - Re * cost(prevMid, mid) + cost(mid, j);
            cost = L + R;
            minCost = (int)Math.min(cost, minCost);
        }
        return minCost;
    }
    

    private int cost(int i, int j){
        return list.get(j) - list.get(i) - (j-i);
     
    }
}