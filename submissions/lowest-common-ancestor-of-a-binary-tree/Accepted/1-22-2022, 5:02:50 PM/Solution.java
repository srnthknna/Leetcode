// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

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
    
    TreeNode ans;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }
    
    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        
        int left = helper(root.left, p, q) ? 1 : 0;
        int right = helper(root.right, p , q) ? 1 : 0;
        int mid = (p == root || q == root) ? 1 : 0;
        
        if (left + right + mid >= 2) ans = root;
        
        return (left + right + mid) > 0;
    }
}