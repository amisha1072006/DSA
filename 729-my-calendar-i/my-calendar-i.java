class Node{
    int start,end;
    Node left;
    Node right;
    public Node(int start , int end){
        this.start=start;
        this.end=end;
        left=null;
        right=null;
    }
}

class MyCalendar {
 Node root;
    public MyCalendar() {
      this.root = null;
 
    }
    public boolean insert(Node parent , int s , int e){
        if (parent.start>=e){
            if(parent.left==null){
                parent.left=new Node(s,e);
                return true;
            }
            else{
                return insert(parent.left,s,e);
            }
        }
        else if (parent.end<=s){
            if(parent.right==null){
                parent.right=new Node(s,e);
                return true;
            }
            else{
                return insert(parent.right,s,e);
            }
        }
        
            return false;
    }
    public boolean book(int startTime, int endTime) {
                if(root == null){
            root= new Node(startTime,endTime);
            return true;
        }
        else{
            return insert(root,startTime,endTime);
        }
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */