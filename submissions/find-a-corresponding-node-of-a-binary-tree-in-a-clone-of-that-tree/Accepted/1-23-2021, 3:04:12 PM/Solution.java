// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree

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
    
    TreeNode ans, target;
    private void inorder(final TreeNode original, final TreeNode cloned) {
        if (original != null) {
            if (original == target) {
                ans = cloned;
            } else {
                inorder(original.left, cloned.left);
                inorder(original.right, cloned.right);
            }
        }
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inorder(original, cloned);
        return ans;
    }
}