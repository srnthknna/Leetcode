// https://leetcode.com/problems/binary-tree-maximum-path-sum

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
    int maxSum = 0;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        
        int leftSum = Math.max(helper(root.left), 0);
        int rightSum = Math.max(helper(root.right), 0);
        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
        
        return root.val + Math.max(leftSum, rightSum);
    }
}