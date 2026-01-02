/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
                ListNode temp=head;
        if(head==null ){
            return null;
        }
        
         if (head.next== null) return head; 
       
        int value=x;
        ListNode dummy =new ListNode();
        ListNode dummy2=new ListNode();
        ListNode tempd1=dummy;
        ListNode tempd2=dummy2;
        ListNode itt=head;
        while(itt!=null){
            if(itt.val<value){
                tempd1.next=itt;
                tempd1=tempd1.next;
            }
            else{
                tempd2.next=itt;
                tempd2=tempd2.next;
            }
            itt=itt.next;
        }
      
        tempd2.next=null;
        tempd1.next=dummy2.next;
        
        return dummy.next;

    }
}