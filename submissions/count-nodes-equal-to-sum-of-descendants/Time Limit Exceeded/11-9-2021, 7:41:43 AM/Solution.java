// https://leetcode.com/problems/count-nodes-equal-to-sum-of-descendants

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
    int count = 0;
    public int equalToDescendants(TreeNode root) {
        inorder(root);
        return count;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        
        if (root.val == sum(root) - root.val)
            count++;
        
        inorder(root.right);
    }
    
    private int sum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}