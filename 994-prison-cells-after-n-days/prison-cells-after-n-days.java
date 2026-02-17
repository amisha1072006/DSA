class Solution {
    private int toInteger(int[] cells){
        int res = 0;
        for(int i = 0; i < 8;i++){
            res += (1 << i) * cells[i];
        }
        return res;
    }
    public int[] prisonAfterNDays(int[] cells, int N) {
                LinkedHashMap<Integer, int[]> map = new LinkedHashMap<>();
        int K = 0;
        while(K < N){
            int[] newCell = new int[8];
            for(int i = 1; i < 7;i++){
                newCell[i] = cells[i - 1] == cells[i + 1]? 1 : 0;
            }
            cells = newCell;
            int key = toInteger(cells);
            if(map.containsKey(key)){
                break;
            }
            map.put(key, cells);
            K++;
           
        }
        //K is the cycle length
        if(K < N){
            ArrayList<Integer> arr = new ArrayList<>(map.keySet());
            //IMPORTANT, the array index start at 0
            //We need to pad it so that the day index starts on 1, which align with N % K index lookup
            arr.add(0, -1);
            int idx = N % K;
            //If N % K is 0, that means we want the last element of the cycle
            return map.get(arr.get(idx == 0? arr.size() - 1 : idx));
         
        }
        return cells;
    
    }
}