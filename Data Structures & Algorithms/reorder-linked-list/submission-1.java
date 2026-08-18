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
    public void reorderList(ListNode head) {
        if(head.next == null) {
            return;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        // Reverse the 2nd half list
        dummy = null;
        ListNode current = dummy;
        while(fast != null) {
            dummy = fast;
            fast = fast.next;
            dummy.next = current;
            current = dummy;
        }
        int counter = 0;
        current = head;
        slow = head;
        while(slow != null && dummy != null) {
            if(counter % 2 == 0) {
                slow = slow.next;
                current.next = dummy;
                current = current.next;                
            } else {
                dummy = dummy.next;
                current.next = slow;
                current = current.next;
            }
            counter++;
        }
        //return slow;
    }
}
