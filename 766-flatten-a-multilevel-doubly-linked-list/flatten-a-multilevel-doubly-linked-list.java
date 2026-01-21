/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
                Node temp = head;
        Stack<Node> st = new Stack<>();
        while(temp != null){
           if(temp.child != null){
                if(temp.next != null){
                    st.push(temp.next);
                }
                temp.next = temp.child;
                temp.child.prev = temp;
                temp.child = null;
           }
           if(!st.isEmpty() && temp.next == null){
                Node nn = st.pop();
                temp.next = nn;
                nn.prev = temp;
           }
           temp = temp.next;
        }
        return head;

    }
}