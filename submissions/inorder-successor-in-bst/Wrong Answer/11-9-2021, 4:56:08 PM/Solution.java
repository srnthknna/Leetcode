// https://leetcode.com/problems/inorder-successor-in-bst

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
    TreeNode prev;
    TreeNode next;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root, p);
        return next;
    }
    
    private void helper(TreeNode root, TreeNode p) {
        if (root != null) {
            inorderSuccessor(root.left, p);
           
            if (prev == p)  { 
                next = root;
                return;
            }
            
            prev = root; 
            inorderSuccessor(root.right, p);
        }
    }
}