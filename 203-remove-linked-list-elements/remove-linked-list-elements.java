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
    public ListNode removeElements(ListNode head, int val) {
    while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return null;
        }
        ListNode current = head;
        while(current.next!=null){
            if(current.next.val == val){
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return head;
    // if(head == null){
    //     return null;
    // }
    // if(head.val != val){
    //   head.next =  removeElements(head.next,val);
    //     return head;
    // }
    // return removeElements(head.next,val);
    }
}