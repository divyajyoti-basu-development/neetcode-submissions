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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, val;
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while(l1 != null && l2 != null) {
            val = carry + l1.val + l2.val;
            carry = val / 10;
            current.next = new ListNode(val % 10);
            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }
        if(l1 == null && l2 != null) {
            while(l2 != null) {
                val = carry + l2.val;
                carry = val / 10;
                current.next = new ListNode(val % 10);
                l2 = l2.next;
                current = current.next;
            }
        } else if(l2 == null && l1 != null) {
            while(l1 != null) {
                val = carry + l1.val;
                carry = val / 10;
                current.next = new ListNode(val % 10);
                l1 = l1.next;
                current = current.next;
            }
        }
        if(carry != 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
