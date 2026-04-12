class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] unlocked=new boolean[rooms.size()];

        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        unlocked[0]=true;
        while(!queue.isEmpty()){
            int val=queue.poll();          
            for(int i=0;i<rooms.get(val).size();i++){
                if(unlocked[rooms.get(val).get(i)]==true) continue;
                queue.offer(rooms.get(val).get(i));
                unlocked[rooms.get(val).get(i)]=true;
            }
        }
        boolean flag=true;
           for(int i=0;i<unlocked.length;i++){
                if(unlocked[i]==false){
                    flag=false;
                }
           }
           
           return flag;
    }
}