class DataStream {
       private final int value, k;
    private int count;

    public DataStream(final int value, final int k) {
        this.value = value;
        this.k = k;
        this.count = 0;
    }
    
    public boolean consec(final int num) {
        if(num == value)
            count++;
        else
            count = 0;

        return k <= count;
        
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */