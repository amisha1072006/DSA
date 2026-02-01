class Solution {
    public int rob(int[] nums) {
        int[] teli=new int[nums.length];
        Arrays.fill(teli,-1);
        return pasa(nums,0,teli);

    }
    public int pasa(int[] nums,int ind,int [] teli)
    {
        if(ind>=nums.length)
        {
            return 0;
        }
        else
        {
            if(teli[ind]!=-1)
            {
                return teli[ind];
            }
            teli[ind]= Math.max( nums[ind] + pasa(nums,ind+2,teli)  ,  pasa(nums,ind+1,teli) );
            return teli[ind]; 
        }
  
    }
}