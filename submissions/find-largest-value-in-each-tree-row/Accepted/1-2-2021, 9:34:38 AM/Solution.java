// https://leetcode.com/problems/find-largest-value-in-each-tree-row

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> max_vals = new ArrayList<>();
        
        helper(root, max_vals, 0);
        
        return max_vals;
    }
    
    private void helper(TreeNode root, List<Integer> max_vals, int level) {
        if (root == null) return;
        
        if (max_vals.size() == level) {
            max_vals.add(root.val);
        } else {
            max_vals.set(level, Math.max(root.val, max_vals.get(level)));
        }
        
        helper(root.left, max_vals, level + 1);
        helper(root.right, max_vals, level + 1);
    }
}