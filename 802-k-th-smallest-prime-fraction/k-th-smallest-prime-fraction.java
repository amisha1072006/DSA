class Solution {
        public class Pair{
        int e1;
        int e2;
        double frac;
        public Pair(int e1, int e2, double frac){
            this.e1 = e1;
            this.e2 = e2;
            this.frac = frac;
        }
    }
   
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        if(k == 1){
            return new int[]{arr[0],arr[n-1]};
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return Double.compare(o1.frac,o2.frac);
            }
        });

        pq.add(new Pair(0,n-1,arr[0]*1.0/arr[n-1]));
        HashSet<String> vis = new HashSet<>();
        // k--;
        while(!pq.isEmpty() && k != 0){
            Pair rv = pq.poll();
            int r = rv.e1;
            int c = rv.e2;
            k--;
            if(k == 0){
                return new int[]{arr[r],arr[c]};
            }
            if(r+1 < c && (!vis.contains(r+1+"-"+c))){
                pq.add(new Pair(r+1,c,arr[r+1]*1.0/arr[c]));
                vis.add(r+1+"-"+c);
            }
            if(c-1 > r && (!vis.contains(r+"-"+(c-1)))){
                pq.add(new Pair(r,c-1,arr[r]*1.0/arr[c-1]));
                vis.add(r+"-"+(c-1));
            }
        }
        return new int[]{-1,-1};
    
    }
}