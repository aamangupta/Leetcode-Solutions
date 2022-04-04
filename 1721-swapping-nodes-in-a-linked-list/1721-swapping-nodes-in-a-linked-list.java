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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode prev = null, n1 = head, n2 = head, f = head;
        for(int i = 0; i < k; i++){
            prev = f;
            f = f.next;
        }
        n1 = prev;
        while(f != null){
            n2 = n2.next;
            f = f.next;
        }
        int t = n1.val;
        n1.val = n2.val;
        n2.val = t;
        
        return head;
    }
}