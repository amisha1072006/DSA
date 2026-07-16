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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode ttail=head;
        ListNode thead=head;
        ListNode ohead=head;
        //taking tail to last node
        int len=0;
        while(ttail!=null){
            ttail=ttail.next;
            len++;
        }
        k = k % len;
        if(k == 0) return head;
        ttail=head;
        for(int i=0;i<len-k-1;i++){
            ttail=ttail.next;
        }
        thead=ttail.next;
        ttail.next=null;
        ListNode newHead = thead;

        while(thead.next!=null){
            thead=thead.next;
        }
        thead.next=ohead;
        return newHead;
    }
}