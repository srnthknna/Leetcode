// https://leetcode.com/problems/recover-binary-search-tree

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
    TreeNode x = null, y = null, prev = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        
        if (x == null && prev != null && prev.val > root.val) {
            x = prev;
        } else if (y == null && prev != null && prev.val > root.val) {
            y = root;
            return;
        }
        prev = root;
        
        inorder(root.right);
    }
}