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
        ListNode n1 = l1, n2 = l2, dummy = new ListNode(-1), d = dummy;
        int carry = 0;
        
        while(n1 != null && n2 != null){
            int sum = n1.val + n2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            n1 = n1.next;
            n2 = n2.next;
            d.next = new ListNode(val);
            d = d.next;
        }
        if(n1 != null){
            while(n1 != null){
                int sum = carry + n1.val;
                carry = sum / 10;
                int val = sum % 10;
                d.next = new ListNode(val);
                d = d.next;
                n1 = n1.next;
            }
        }
        
        if(n2 != null){
            while(n2 != null){
                int sum = carry + n2.val;
                carry = sum / 10;
                int val = sum % 10;
                d.next = new ListNode(val);
                d = d.next;
                n2 = n2.next;
            }
        }
        if(carry != 0){
            d.next = new ListNode(carry);
            d = d.next;
        }
        return dummy.next;
    }
}