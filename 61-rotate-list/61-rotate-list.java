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
    public ListNode rev(ListNode node){
        ListNode prev = null, curr = node;
        while(curr != null){
            ListNode n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        return prev;
    }
    public int size(ListNode node){
        if(node == null) return 0;
        return 1 + size(node.next);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null) return head;
        int n = size(head);
        k = k % n;
        int n1 = n - k;
        ListNode node = head, t = node;
        for(int i = 0; i < n1 - 1; i++){
            node = node.next;
        }
        ListNode n2 = node.next;
        node.next = null;
        ListNode r1 = rev(t), r2 = rev(n2), t1 = r1;
        
        while(t1.next != null) t1 = t1.next;
        t1.next = r2;
        return rev(r1);
    }
}