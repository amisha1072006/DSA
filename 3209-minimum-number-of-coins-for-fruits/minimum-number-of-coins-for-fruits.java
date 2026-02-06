class Solution {
    public int minimumCoins(int[] prices) {
                int n=prices.length;
        for(int i=(n-1)/2;i>0;i--){
            int min=prices[i*2];
            for(int j=i;j<i*2;j++){
                min=Math.min(prices[j],min);
            }
            prices[i-1]+=min;
        }
        return prices[0];
    
    }
}