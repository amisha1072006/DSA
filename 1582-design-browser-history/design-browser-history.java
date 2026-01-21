class BrowserHistory {
ArrayList<String> K;
 int c;
    public BrowserHistory(String homepage) {
                K = new ArrayList<>();
        c  = 0;
        K.add(homepage);

    }
    
    public void visit(String url) {
        for(int i  = K.size()-1 ; i > c ;i--){
        K.remove(i);
    }
    K.add(url);
    c++;
    
    }
    
    public String back(int steps) {
        if(c-steps < 0){
            c = 0;
            return K.get(c);
        }
    c = c-steps;
    return K.get(c);

    }
    
    public String forward(int steps) {
             if(c+steps >= K.size()){
        c = K.size()-1;
        return K.get(c);
     }

     c = c+steps;
     return K.get(c);

    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */