class Router {
 int limit;
    Set<List<Integer>> set;
    Deque<List<Integer>> deque;
    Map<Integer, List<Integer>> map;
    Map<Integer, Integer> starts;       

    public Router(int memoryLimit) {
        limit = memoryLimit;
        set = new HashSet<>();
        deque = new ArrayDeque<>();
        map = new HashMap<>(); 
        starts = new HashMap<>();    
    
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
                List<Integer> toAdd = new ArrayList<>(); 
        toAdd.add(source); 
        toAdd.add(destination); 
        toAdd.add(timestamp);
        if (set.size() < limit && set.add(toAdd)){
            deque.offer(toAdd);
            if (!map.containsKey(destination)){
                map.put(destination, new ArrayList<>());
                starts.put(destination, 0); 
            }
            map.get(destination).add(timestamp);
            return true; 
        } else if (set.size() == limit && !set.contains(toAdd)){
            int prior = deque.peek().get(1); 
            set.remove(deque.peek()); 
            deque.poll();
            if (!map.containsKey(destination)){
                map.put(destination, new ArrayList<>());
                starts.put(destination, 0);  
            }
            map.get(destination).add(timestamp);
            starts.put(prior, starts.get(prior) + 1); 
            set.add(toAdd); 
            deque.offer(toAdd); 
            return true; 
        }
        return false; 
    }
    
    public int[] forwardPacket() {
                if (deque.isEmpty()){
            return new int[0]; 
        }
        int[] res = new int[3]; 
        res[0] = deque.peek().get(0); 
        res[1] = deque.peek().get(1); 
        res[2] = deque.peek().get(2);
        set.remove(deque.peek()); 
        deque.poll();
        starts.put(res[1], starts.get(res[1]) + 1); 
        return res;  
    
    }
    
    public int getCount(int destination, int startTime, int endTime) {
       if (!map.containsKey(destination)){
            return 0; 
        }
        List<Integer> list = map.get(destination);
        int start = starts.get(destination);
        if (start >= list.size() || list.get(start) > endTime || list.get(list.size() - 1) < startTime){
            return 0; 
        }
        int l = start; 
        int r = list.size() - 1;
        int beg = 0; 
        while (l <= r){
            int mid = l + (r - l)/2;
            if (list.get(mid) < startTime){
                l = mid + 1; 
            } else {
                beg = mid;
                r = mid - 1;  
            }
        }
        l = start; 
        r = list.size() - 1; 
        int end = 0; 
        while (l <= r){
            int mid = l + (r - l)/2; 
            if (list.get(mid) > endTime){
                r = mid - 1; 
            } else {
                l = mid + 1; 
                end = mid; 
            }
        }    
        return end - beg + 1; 
     
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */