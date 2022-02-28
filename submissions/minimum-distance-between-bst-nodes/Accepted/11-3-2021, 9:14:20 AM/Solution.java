// https://leetcode.com/problems/minimum-distance-between-bst-nodes

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
    Integer prev, ans;
    public int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        inorder(root);
        return ans;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        
        inorder(root.left);
        
        if (prev != null) {
            ans = Math.min(ans, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }
}