/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0){
            Queue<Node> innerQ = new ArrayDeque<>();
            int n = q.size();
            while(n-- > 0){
                Node rem1 = q.remove();
                Node rem2 = null;
                if(q.size() != 0) rem2 = q.peek();
                rem1.next = rem2;
                if(rem1.left != null) innerQ.add(rem1.left);
                if(rem1.right != null) innerQ.add(rem1.right);
            }
            q = innerQ;
        }
        return root;
    }
}