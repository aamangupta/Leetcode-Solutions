/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void helper(Node i, Node node, Node []arr){
        Node nn = new Node();
        if(arr[i.val] != null) nn = arr[i.val];
        else {
            nn = new Node(i.val);
            arr[i.val] = nn;
        }
        for(Node j : node.neighbors){
            if(arr[j.val] == null){
                Node nu = new Node(j.val);
                arr[j.val] = nu;
                nn.neighbors.add(nu);
                helper(nu, j, arr);
            }else{
                Node nu = arr[j.val];
                nn.neighbors.add(nu);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node[]arr = new Node[101];
        helper(node, node, arr);
        return arr[1];
    }
}