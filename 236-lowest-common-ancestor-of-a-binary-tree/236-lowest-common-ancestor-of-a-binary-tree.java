/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public ArrayList<TreeNode> path(TreeNode n, TreeNode node){
        ArrayList<TreeNode> base = new ArrayList<>();
        if(node == null) return base;
        if(node == n) {
            base.add(n);
            return base;
        }
        
        ArrayList<TreeNode> l = path(n, node.left);
        if(l.size() > 0){
            l.add(node);
            return l;
        }
        ArrayList<TreeNode> r = path(n, node.right);
        if(r.size() > 0){
            r.add(node);
            return r;
        }
        return base;
    }
    public TreeNode check(ArrayList<TreeNode> p1, ArrayList<TreeNode> p2){
        int s1 = p1.size(), s2 = p2.size();
        int diff = s1 - s2;
        int n1 = 0, n2 = 0;
        while(diff-- > 0) n1++;
        while(p1.get(n1) != p2.get(n2)){
            n1++;
            n2++;
        }
        return p1.get(n1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathp = path(p, root);
        ArrayList<TreeNode> pathq = path(q, root);
        int psize = pathp.size(), qsize = pathq.size();
        if(psize == qsize){
            int n1 = 0, n2 = 0;
            while(pathp.get(n1) != pathq.get(n2)){
                n1++;
                n2++;
            }
            return pathp.get(n1);
        }else{
            if(psize > qsize){
                TreeNode ans = check(pathp, pathq);
                return ans;
            }else return check(pathq, pathp);
        }
    }
}