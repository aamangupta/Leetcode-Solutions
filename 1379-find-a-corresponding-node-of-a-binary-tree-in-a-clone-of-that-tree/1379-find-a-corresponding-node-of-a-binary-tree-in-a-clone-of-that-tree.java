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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned == null) return null;
        if(target == original) return cloned;
        TreeNode l = getTargetCopy(original.left, cloned.left, target);
        if(l != null) return l;
        TreeNode r = getTargetCopy(original.right, cloned.right, target);
        if(r != null) return r;
        return null;
    }
}