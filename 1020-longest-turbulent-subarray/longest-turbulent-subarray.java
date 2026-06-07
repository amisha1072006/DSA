class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;

        if(n == 1) return 1;

        int inc = 1;
        int dec = 1;
        int max = 1;

        for(int i=1;i<n;i++)
        {
            if(arr[i] > arr[i-1])
            {
               inc = dec + 1;
               dec = 1;
            }
            else if(arr[i] < arr[i-1])
            {
                dec = inc + 1;
                inc = 1;
            }
            else
            {
                inc = 1;
                dec = 1;
            }
            max = Math.max(max,Math.max(inc,dec));
        }
        return max;
    }
}