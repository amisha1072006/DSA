class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        // BRUTE FORCE APPROACH
        // TC = O((maxElement - minElement + 1) * n), SC = O(1)

//         int n = bloomDay.length;
//         if(n < m*k){
//             return -1;
//         }
//         int maxElement = bloomDay[0];
//         int minElement = bloomDay[0];
//         int cnt = 0;
//         int bouquet = 0;
//         for(int i = 1; i<n; i++){
//             if(bloomDay[i] > maxElement){
//                 maxElement = bloomDay[i];
//             }
//             if(bloomDay[i] < minElement){
//                 minElement = bloomDay[i];
//             }
//         }
//         for(int i = minElement; i <= maxElement; i++){
//             bouquet = 0;
//             cnt = 0;
//             for(int j = 0; j<n; j++){
//                 if(bloomDay[j] <= i){
//                   cnt++;
//                 }else{
//                     bouquet += cnt/k;
//                     cnt = 0;
//                 }   
//             }
//             bouquet += cnt/k;
//             if(bouquet >= m){
//                 return i;
//             }
//         } 
//         return -1;
//     }
// }

// OPTIMAL APPROACH
// TC = O(n * log(maxElement - minElement + 1)), SC = O(1)

        if(bloomDay.length < m*k){
            return -1;
        }
        int maxElement = bloomDay[0];
        int minElement = bloomDay[0];
        for(int i = 1; i < bloomDay.length; i++){
            if(bloomDay[i] > maxElement){
                maxElement = bloomDay[i];
            }
            if(bloomDay[i] < minElement){
                minElement = bloomDay[i];
            }
        }
            int left = minElement;
            int right = maxElement;
            int ans = -1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if(func(bloomDay, mid, m, k) == true){
                    ans = mid;
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        return ans;
    }
    public static boolean func(int[] bloomDay, int mid, int m, int k){
        int n = bloomDay.length;
        int cnt = 0;
        int bouquet = 0;
        for(int j = 0; j<n; j++){
                if(bloomDay[j] <= mid){
                  cnt++;
                }else{
                    bouquet += cnt/k;
                    cnt = 0;
                }   
            }
            bouquet += cnt/k;
            if(bouquet >= m){
                return true;
            }
        return false;
    }
}