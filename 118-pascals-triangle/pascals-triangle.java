class Solution {
    public List<List<Integer>> generate(int numRows) {
        int n  = numRows;

    // BRUTE FORCE APPROACH
    // TC = O(n*n*r) = O(n^3) 
    
    List<List<Integer>> list1 = new ArrayList<>();
    for(int row = 1; row <= n; row++){
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int col = 1; col <= row; col++){
            list2.add(pascalTriangleI(row, col));
        }
        list1.add(list2);
    }
    return list1;
    }
    public static int pascalTriangleI(int r, int c){
        int n = r-1;
        int k = c-1;
        long res = 1;
        for(int i = 0; i < k; i++){
            res = res *(n-i);
            res = res / (i+1);
        }
        return (int)res;

    // OPTIMAL APPROACH
    // TC = O(n * n), SC O(1)

    // List<List<Integer>> ans = new ArrayList<>();
    // for(int i = 1; i<=n; i++){
    //   List<Integer> ansRow = new ArrayList<>();
    //   long res = 1;
    //   ansRow.add((int)res);
    //   for(int col = 1; col<i; col++){
    //      res = res * (i-col);
    //      res = res / (col); 
    //      ansRow.add((int)res);
    //   }
    //   ans.add(ansRow);
    // }
    // return ans;
    }
}