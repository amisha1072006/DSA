class Solution {
    public int maxChunksToSorted(int[] arr) {
                TreeSet<Integer> sortedSet = new TreeSet<>();
        int i = 0;
        int j = 0;
        int c = 0;
        while(j<arr.length){
            int num = arr[j];
            sortedSet.add(num);
            if(sortedSet.first() == i && sortedSet.last() == j){
                c++;
                sortedSet.clear();
                i=j+1;
            }
            j++;
        }
        return c;

    }
}