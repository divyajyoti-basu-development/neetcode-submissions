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
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int num;
        while(list1 != null && list2 != null) {
            num = list1.val + list2.val + carry;
            carry = num / 10;
            num = num % 10;
            current.next = new ListNode(num);
            current = current.next;
            list1 = list1.next;
            list2 = list2.next;
        }
        if(list1 == null && list2 != null) {
            while(list2 != null) {
                num = carry + list2.val;
                carry = num / 10;
                num = num % 10;
                current.next = new ListNode(num);
                current = current.next;
                list2 = list2.next;
            }
        }
        else if(list1 != null && list2 == null) {
            while(list1 != null) {
                num = carry + list1.val;
                carry = num / 10;
                num = num % 10;
                current.next = new ListNode(num);
                current = current.next;
                list1 = list1.next;
            }
        }
        if(carry != 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
