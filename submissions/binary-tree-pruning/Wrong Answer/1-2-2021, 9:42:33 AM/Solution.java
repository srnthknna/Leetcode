// https://leetcode.com/problems/binary-tree-pruning

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        
        containsOne(root);
        
        return root;
    }
    
    private boolean containsOne(TreeNode root) {
        if (root == null) return false;
        
        boolean left = containsOne(root.left);
        boolean right = containsOne(root.right);
        
        if (!left) {
            root.left = null;
        }
        
        if (!right) {
            root.right = null;
        }
        
        return root.val == 1 || left || right;
    }
}