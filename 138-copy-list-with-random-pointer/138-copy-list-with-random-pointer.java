/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node t = head;
        while(t != null){
            Node nex = t.next;
            Node temp = new Node(t.val);
            temp.next = nex;
            t.next = temp;
            t = t.next.next;
        }
        t = head;
        while(t != null){
            if(t.random != null)
            t.next.random = t.random.next;
            t = t.next.next;
        }
        Node nn = new Node(-1);
        Node tn = nn;
        t = head;
        while(t != null){
            Node nex = t.next.next;
            
            tn.next = t.next;
            t.next = nex;
            tn = tn.next;
            t = nex;
        }
        return nn.next;
    }
}