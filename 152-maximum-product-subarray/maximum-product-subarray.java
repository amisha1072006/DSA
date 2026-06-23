class Solution {
    public int maxProduct(int[] A) {
        //        if (A == null || A.length == 0) {
        //     return 0;
        // }
        // int max = A[0], min = A[0], result = A[0];
        // for (int i = 1; i < A.length; i++) {
        //     int temp = max;
        //     max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
        //     min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
        //     if (max > result) {
        //         result = max;
        //     }
        // }
        // return result;

        if(A ==null || A.length == 0){
            return 0;
        }
        // SCAN FROM LEFT TO RIGHT
        int maximumProd = A[0];
        int currentProd = 1;
        for(int i = 0; i<A.length; i++){
            currentProd *= A[i];
            if(maximumProd < currentProd){
                maximumProd = currentProd;
            }
            if(A[i] == 0){
                currentProd =1;
            }
        }
        // SCAN FROM RIGHT TO LEFT
        currentProd = 1;
        for(int i =A.length-1; i>=0; i--){
                       currentProd *= A[i];
            if(maximumProd < currentProd){
                maximumProd = currentProd;
            }
            if(A[i] == 0){
                currentProd =1;
            }
        } 
        return maximumProd;
    }
}