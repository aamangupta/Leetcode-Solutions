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
    public final TreeNode helper(final TreeNode tar, final TreeNode cloned){
        if(cloned == null) return null;
        if(tar.val == cloned.val) return cloned;
        TreeNode l = helper(tar, cloned.left);
        if(l != null) return l;
        TreeNode r = helper(tar, cloned.right);
        if(r != null) return r;
        return null;
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return helper(target, cloned);
    }
}