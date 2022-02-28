// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor

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
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return helper(root, root.val, root.val);
    }
    
    private int helper(TreeNode root, int curMax, int curMin) {
        if (root == null) {
            return curMax - curMin;
        }
        curMax = Math.max(curMax, root.val);
        curMin = Math.min(curMin, root.val);
        int left = helper(root.left, curMax, curMin);
        int right = helper(root.right, curMax, curMin);
        return Math.max(left, right);
    }
}