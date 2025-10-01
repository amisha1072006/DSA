/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
      // Edge case: empty list or single node cannot form a cycle
        if (head == null || head.next == null) return false;

        ListNode slow = head;       // moves 1 step at a time
        ListNode fast = head.next;  // moves 2 steps at a time

        while (slow != fast) {
            // If fast reaches the end, no cycle exists
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;       // move slow pointer by 1
            fast = fast.next.next;  // move fast pointer by 2
        }

        // If slow == fast, pointers met inside a cycle
        return true;
    
    }
}