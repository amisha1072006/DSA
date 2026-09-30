class Solution {
    public List<Integer> getRow(int rowIndex) {
            // BRUTE FORCE APPROACH
        // TC = O(r *c), SC = O(1)

    //    List<Integer> list = new ArrayList<>();
    //    for(int c=1; c<=rowIndex+1; c++){
    //          list.add(pascalTriangleI(rowIndex+1, c));
    //    }
    //    return list;
    // }
    // public static int pascalTriangleI(int r, int c){
    //     int n = r-1;
    //     int k = c-1;
    //     long res = 1;
    //     for(int i = 0; i<k; i++){
    //         res = res * (n-i);
    //         res = res / (i+1);
    //     }
    //     return (int) res;

    // OPTIMAL APPROACH
    // TC = O(r), SC = O(1)

    
    int k = 0;
    long ans = 1;
    List<Integer> list = new ArrayList<>();
    list.add((int)ans);
    for(int i = 1; i<=rowIndex; i++){
        ans = ans * (rowIndex-i+1);
        ans = ans / (i);
         list.add((int)ans);
    }
    return list;

    }
}