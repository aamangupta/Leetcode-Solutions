/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int s1 = size(headA);
        int s2 = size(headB);
        
        int diff = Math.abs(s1 - s2);
        ListNode t1 = headA;
        ListNode t2 = headB;
        
        if(s1 > s2){
            while(diff-- > 0) t1 = t1.next;
        }else{
            while(diff-- > 0) t2 = t2.next;
        }
        
        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1;
    }
    public int size(ListNode n){
        ListNode t = n;
        int s = 0;
        while(t != null){
            t = t.next;
            s++;
        }
        return s;
    }
}