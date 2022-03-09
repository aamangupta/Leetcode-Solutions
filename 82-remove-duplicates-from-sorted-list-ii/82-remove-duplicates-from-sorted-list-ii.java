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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode d = new ListNode(-1);
        ListNode t = d, n = head;
        while(n != null){
            if(n.next != null && n.val == n.next.val){
                int val = n.val;
                while(n.next != null && n.val == n.next.val){
                    n = n.next;
                }
                n = n.next;
            }else{
                t.next = n;
                t = t.next;
                n = n.next;
            }
        }
        t.next = null;
        return d.next;
    }
}