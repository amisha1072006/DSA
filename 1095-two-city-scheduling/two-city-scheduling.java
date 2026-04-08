class Solution {
    public int twoCitySchedCost(int[][] costs) {
                int ans = 0;
        int n=costs.length;
        n=n/2;

        Arrays.sort(costs, (a,b) -> Integer.compare(b[1]-b[0],a[1]-a[0]));
        for(int i=0;i<n;i++){
            ans+=costs[i][0]+costs[i+n][1];
        }
        return ans;

    }
}