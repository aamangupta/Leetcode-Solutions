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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h1 = list1, h2 = list2, d = new ListNode(-1), t = d;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                t.next = h1;
                h1 = h1.next;
            }else {
                t.next = h2;
                h2 = h2.next;
            }
            t = t.next;
        }
        if(h1 != null) t.next = h1;
        if(h2 != null) t.next = h2;
        
        return d.next;
    }
}