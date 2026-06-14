class Solution {
        boolean isNonDec(List<Integer> arr)
    {
        for(int i=1;i<arr.size();i++)
        {
            if(arr.get(i)<arr.get(i-1))
            {
                return false;
            }
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr=new ArrayList();
        for (int x : nums) 
        {
            arr.add(x); 
        }
        int count=0;
        while(!isNonDec(arr))
        {
            int mini=Integer.MAX_VALUE;
            int ind=0;
        for(int i=0;i<arr.size()-1;i++)
        {
            if(mini>arr.get(i)+arr.get(i+1))
            {
                mini=arr.get(i)+arr.get(i+1);
                ind=i;
            }
        }
        arr.remove(ind);
        arr.set(ind,mini);
        count++;
        }
        return count;
    }
}