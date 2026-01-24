class RangeFreqQuery {
    Map<Integer, Integer>[] st;
    int[] a;
    int n;

    public RangeFreqQuery(int[] arr) {
       n = arr.length;
        st = new HashMap[n * 4];
        a = arr;

        build(1, 0, n - 1);
    }

    void build(int v, int tl, int tr){
        if(tl == tr){
            Map<Integer, Integer> m = new HashMap<>();
            m.put(a[tl], 1);
            st[v] = m;
            return;
        }

        int mid = (tl + tr) >> 1;
        build(v * 2, tl, mid);
        build(v * 2 + 1, mid + 1, tr);
        
        st[v] = merge(st[v * 2], st[v * 2 + 1]);
    }

     Map<Integer, Integer> merge(Map<Integer, Integer> a,  Map<Integer, Integer> b){
         Map<Integer, Integer> map = new HashMap<>();

        for (int i : a.keySet())
            map.put(i, map.getOrDefault(i, 0) + a.get(i));

        for (int i : b.keySet())
            map.put(i, map.getOrDefault(i, 0) + b.get(i));
        
        return map;
     
    }
    
    public int query(int left, int right, int value) {
                return getQuery(1, 0, n - 1, left, right, value);
    }

    int getQuery(int v, int tl, int tr, int l, int r, int val){ 
        if(l > r)
            return 0;
        if(tl == l && tr == r){
            if(st[v].get(val) == null) return 0;
            else return st[v].get(val);
        }

        int mid = (tl + tr) >> 1;
        return getQuery(v * 2, tl, mid, l, Math.min(mid, r), val) + getQuery(v * 2 + 1, mid + 1, tr, Math.max(mid + 1, l), r, val);

    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */