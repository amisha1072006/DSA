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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int low = left -1;
        int high = right - 1;
        while(low < high){
            int temp1 = list.get(low);
            list.set(low,list.get(high));
            list.set(high,temp1);
            low++;
            high--;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp2 = dummy;
        int index = 0;
        while(index < list.size()){
            temp2.next = new ListNode(list.get(index++));
            temp2 = temp2.next;
        }
        return dummy.next;
    }
}