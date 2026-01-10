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
    public ListNode sortList(ListNode head) {
               if(head == null || head.next == null) return head;
        ListNode Curr = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while(Curr != null) {
            arr.add(Curr.val);
            Curr = Curr.next;
        }
        Collections.sort(arr);
        ListNode NewNode = new ListNode();
        ListNode prev = new ListNode();
        prev.val = 0;
        prev.next = NewNode;
        for(int i = 0; i < arr.size(); i++) {
            if(i == 0) {
                NewNode.val = arr.get(i);
                prev = prev.next;
            } else {
                ListNode temp = new ListNode();
                temp.val = arr.get(i);
                prev.next = temp;
                prev = prev.next;
            }
        }
        head = NewNode;
        return head;
     
    }
}