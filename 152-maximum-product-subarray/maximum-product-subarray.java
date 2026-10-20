class Solution {
    public int maxProduct(int[] A) {
    //   int n = A.length;
    //   int product = 1;
    //   int maxProduct = Integer.MIN_VALUE;

      //BRUTE FORCE APPROACH
      // TC = O(n^3), SC = O(1)

    //   for(int i = 0; i<n; i++){
    //     for(int j = i; j<n; j++){
    //       product = 1;
    //       for(int k = i; k<=j; k++){
    //         product = product * A[k];
    //       }
    //        if(product > maxProduct){
    //         maxProduct = product;
    //        }
    //     }
    //   }

    // BETTER APPROACH
    // TC = O(n^2), SC = O(1)

//      for(int i = 0; i<n; i++){
//          product = 1;
//          for(int j = i; j<n; j++){
//              product = product * A[j];
//               if(product > maxProduct){
//                maxProduct = product;
//             }
//          }
//        }
//       return maxProduct;
//     }
// }

// OPTIMAL AAPROACH
// TC = O(n), SC = O(1)

int n = A.length;
int prefix = 1;
int suffix = 1;
int maxProduct = Integer.MIN_VALUE;
for(int i = 0; i<n; i++){
    if(prefix == 0) prefix = 1;
    if(suffix == 0) suffix = 1;
    prefix = prefix * A[i];
    suffix = suffix * A[n-1-i];
maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
}
return maxProduct;
    }
}