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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int a : nums){
            set.add(a);
        }
        if(head == null){
            return 0;
        }

        ListNode temp = head;
        int count = 0;
        while(temp != null){
            if(set.contains(temp.val)){
                while(temp != null && set.contains(temp.val)){
                    temp = temp.next;
                }
                count++;
            }
            else{
                temp = temp.next;
            }
        }
        return count;
    
    }
}