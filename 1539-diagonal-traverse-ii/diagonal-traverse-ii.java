class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int count  = 0;
        int max = 0;
        for(int i=0 ;i<nums.size(); i++){
            for(int j=0; j<nums.get(i).size(); j++){
                int k = i+j;
                max = Math.max(max,k);
                if(!map.containsKey(k)){
                    map.put(k,new ArrayList<>());
                }
                map.get(k).add(nums.get(i).get(j));
                count++;
            }
        }

        // System.out.println(map);
        // System.out.println(max);
        // System.out.println(count);

        int[] result = new int[count];
        int l = 0;
        for(int i=0; i<max+1; i++){
            ArrayList<Integer> a = map.get(i);
            for(int j = a.size()-1; j>=0; j--){
                result[l++] = a.get(j);
            }
        }

        return result;
    }
}