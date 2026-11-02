class Solution {
    public int shipWithinDays(int[] weights, int days) {
//         int n = weights.length;
//         int maxElement = weights[0];
//         int sum = weights[0];
//         for(int i = 1; i<n; i++){
//            if(weights[i] > maxElement){
//               maxElement = weights[i];
//            }
//            sum += weights[i];
//         }
//         for(int cap = maxElement; cap<= sum; cap++){
//             int daysReq = func(weights, cap);
//             if(daysReq <= days){
//                 return cap;
//             }
//         }
//        return -1; 
//     }
//     public static int func(int[] weights, int cap){
//         int sum = 0;
//         int daysReq = 0;
//         for(int i = 0; i<weights.length; i++){
//             sum += weights[i];
//             if(sum > cap){
//                  daysReq++;
//                  sum = weights[i];
//             }
//         }
//         if(sum > 0){
//             daysReq++;
//         }
//         return daysReq;
//     }
// }

int n = weights.length;
        int maxElement = weights[0];
        int sum = weights[0];
        for(int i = 1; i<n; i++){
           if(weights[i] > maxElement){
              maxElement = weights[i];
           }
           sum += weights[i];
        }
        int left = maxElement;
        int right = sum;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int daysReq = func(weights, mid);
            if(daysReq <= days){
                ans = mid;
                right = mid - 1;
            }
            // else if(daysReq < days){
            //     right = mid - 1;
            // }
            else left = mid + 1;
        }
       return ans; 
    }
    public static int func(int[] weights, int cap){
        int sum = 0;
        int daysReq = 0;
        for(int i = 0; i<weights.length; i++){
            sum += weights[i];
            if(sum > cap){
                 daysReq++;
                 sum = weights[i];
            }
        }
        if(sum > 0){
            daysReq++;
        }
        return daysReq;
    }
}