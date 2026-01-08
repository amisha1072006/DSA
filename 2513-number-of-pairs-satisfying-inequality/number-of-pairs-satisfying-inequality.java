class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
              int n=nums1.length ;
        List<Long> list = new ArrayList<>() ;
        long result = 0 ;
        for(int i = n-1 ; i >=0 ; i--){
            Long k = (long)nums1[i] - (long)nums2[i] ;
            result += find(k,list) ;
            k +=  (long)diff ;
            insert(k,list) ;
        }
        return result;
    }
    public long find(Long k ,List<Long> list){
        int n = list.size() ;
        int low = 0 ;
        int high = n-1 ;
        while(low<=high){
            int mid = (low+high)/2 ;
            if(list.get(mid)>=k)
                high = mid-1 ;
            else
                low = mid+1 ;
        }
        return n - low ;
    }
    public void insert(Long k , List<Long> list ){
        int low = 0 ;
        int high = list.size()-1 ;
        while(low<=high){
            int mid =(low+high)/2 ;
            if(list.get(mid)>=k)
                high = mid-1 ;
            else
                low = mid+1 ;
        }
        list.add(low,k) ;
      
    }
}