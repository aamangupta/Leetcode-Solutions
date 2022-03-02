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
        HashMap<Node, Node> map = new HashMap<>();
        Node tnn = new Node(-1);
        Node nn = tnn;
        Node t = head;
        while(t != null){
            Node tn = new Node(t.val);
            map.put(t, tn);
            nn.next = tn;
            t = t.next;
            nn = nn.next;
        }
        nn = tnn.next;
        t = head;
        while(t != null){
            if(t.random != null) nn.random = map.get(t.random);
            nn = nn.next;
            t = t.next;
        }
        return tnn.next;
    }
}


