class SmallestInfiniteSet {
    int arr[];
    int ind;

    public SmallestInfiniteSet() {
        arr = new int[1001];
        ind = 1;
    
    }
    
    public int popSmallest() {
    while(arr[ind] == 1) ind++;
        arr[ind] = 1;
        return ind;
    
    
    }
    
    public void addBack(int num) {
        if(num < ind) ind = num;
        arr[num] = 0;
    
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */