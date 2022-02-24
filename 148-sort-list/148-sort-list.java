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
    public ListNode merge2sorted(ListNode n1, ListNode n2){
        ListNode l = n1;
        ListNode r = n2;
        ListNode t = new ListNode(-1);
        ListNode d = t;
        while(l != null && r != null){
            if(l.val < r.val){
                d.next = l;
                l = l.next;
            }else{
                d.next = r;
                r = r.next;
            }
            d = d.next;
        }
        if(l != null) {
            d.next = l;
        }else if(r != null) d.next = r;
        
        return t.next;
    }
    public ListNode middle(ListNode node){
        ListNode s = node;
        ListNode f = node;
        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode mid = middle(head);
        ListNode nex = mid.next;
        mid.next = null;
        
        ListNode l = sortList(head);
        ListNode r = sortList(nex);
        
        return merge2sorted(l, r);
    }
}