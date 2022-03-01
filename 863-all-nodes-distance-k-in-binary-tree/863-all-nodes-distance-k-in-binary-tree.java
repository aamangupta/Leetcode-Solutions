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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
//         List<TreeNode> n2rpath = n2r(root, target);
        
//         for(int i = 0; i < n2rpath.size(); i++){
//             TreeNode warn = null;
//             if(i != 0) warn = n2rpath.get(i - 1);
//             kLevelDown(n2rpath.get(i), warn, k, i, list);
//         }
//         return list;
        
        // without using xtra spce
        helper(root, target, k, list);
        return list;
    }
    public int helper(TreeNode node, TreeNode tar, int k,List<Integer> list){
        if(node == null) return -1;
        if(node == tar){
            klevelDown(node, null, k, list);
            return 1;
        }
        
        int l = helper(node.left, tar, k, list);
        if(l != -1){
            klevelDown(node, node.left, k - l, list);
            return l + 1;
        }
        int r = helper(node.right, tar, k, list);
        if(r != -1){
            klevelDown(node, node.right, k - r, list);
            return r + 1;
        }
        return -1;
    }
    public void klevelDown(TreeNode node, TreeNode warn, int k, List<Integer> list){
        if(node == null || node == warn || k < 0) return;
        if(k == 0) {
            list.add(node.val);
            return;
        }
        
        klevelDown(node.left, warn, k - 1, list);
        klevelDown(node.right, warn, k - 1, list);
    }
    public List<TreeNode> n2r(TreeNode node, TreeNode tar){
        List<TreeNode> base = new ArrayList<>();
        if(node == null) return base;
        if(node == tar){
            base.add(node);
            return base;
        }
        
        List<TreeNode> l = n2r(node.left, tar);
        if(l.size() > 0){
            l.add(node);
            return l;
        }
        List<TreeNode> r = n2r(node.right, tar);
        if(r.size() > 0){
            r.add(node);
            return r;
        }
        return base;
    }
    public void kLevelDown(TreeNode node, TreeNode warn, int k, int t, List<Integer> list){
        if(node == null || node == warn) return;
        if(t == k) {
            list.add(node.val);
            return;
        }
        
        kLevelDown(node.left, warn, k, t + 1, list);
        kLevelDown(node.right, warn, k, t + 1, list);
    }
}