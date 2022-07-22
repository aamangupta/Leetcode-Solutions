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
    public ListNode partition(ListNode head, int x) {
        ListNode sh = new ListNode(-1), st = sh, gh = new ListNode(-1), gt = gh, curr = head;
        while(curr != null){
            if(curr.val < x){
                st.next = curr;
                st = st.next;
            }else{
                gt.next = curr;
                gt = gt.next;
            }
            curr = curr.next;
        }
        st.next = gh.next;
        gt.next = null;
        return sh.next;
    }
}