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
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }        
        fast = slow.next; 
        ListNode current, prev = null;
        while(fast != null) {
            current = fast;
            fast = fast.next;
            current.next = prev;
            prev = current;
        }    
        fast = prev;
        slow.next = null;
        slow = head;
        current = dummy;
        boolean isFistListFlag = true;
        while(slow != null || fast != null) {
            if(isFistListFlag) {                
                current.next = slow;
                slow = slow.next; 
                isFistListFlag = false;               
            } else {                
                current.next = fast;
                fast = fast.next;
                isFistListFlag = true;                
            }
            current = current.next;
        }
        //if(slow == null) current.next = fast;      
        //else current.next  
    }
}
