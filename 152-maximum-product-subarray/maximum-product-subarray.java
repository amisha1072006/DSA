class Solution {
    public int maxProduct(int[] A) {
      int n = A.length;
      int product = 1;
      int maxProduct = Integer.MIN_VALUE;
      for(int i = 0; i<n; i++){
         product = 1;
        for(int j = i; j<n; j++){
        //    for(int k = i; k<=j; k++){
            product = product * A[j];
        //    }
           if(product > maxProduct){
            maxProduct = product;
           }
        }
      }
      return maxProduct;
    }
}