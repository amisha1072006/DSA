class Solution {
    public boolean reorderedPowerOf2(int n) {
        HashSet<String> set=new HashSet<>();

        for(int i=0;i<30;i++){
            int pow = 1<<i;
            set.add(sortAsString(pow));            
        }
        return set.contains(sortAsString(n));
    }

    String sortAsString(int n){
        char[] arr= String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}