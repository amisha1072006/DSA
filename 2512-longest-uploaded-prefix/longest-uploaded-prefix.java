class LUPrefix {
    public boolean got [];
    public int pt;
   
    public LUPrefix(int n) {
        got = new boolean[n+1];
        pt = 0;
    
    }
    
    public void upload(int video) {
        got[video] = true;
        while (pt + 1 < got.length && got[pt + 1]) {
            pt++;
        }
    }
    
    public int longest() {
        return pt;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */